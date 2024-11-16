package com.funnovation24.controllers

import com.funnovation24.database.model.LoginLink
import com.funnovation24.database.model.User
import com.funnovation24.database.schema.loginLinks
import com.funnovation24.database.schema.users
import com.funnovation24.plugins.withDatabase
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.find
import org.slf4j.LoggerFactory
import java.util.*

val log = LoggerFactory.getLogger("registerRouting");

fun Route.registerRouting() {
    get("/login-link") {
        val token = call.parameters["token"] ?: throw IllegalArgumentException("token parameter is required");
        withDatabase {
            val loginLink = database.loginLinks.find { it.token eq token } ?: throw NoSuchElementException()
            val user = database.users.find { it.id eq loginLink.userId } ?: throw NoSuchElementException()

            call.respond(user);
        }
    }
    post("/register") {

        val token = call.parameters["token"] ?: throw IllegalArgumentException("token parameter is required");
        val userRequest = call.receive<User>() ?: throw IllegalArgumentException("user parameter is required");

        withDatabase {
            val loginLink = database.loginLinks.find { it.token eq token } ?: throw NoSuchElementException()
            val user = database.users.find { it.id eq loginLink.userId } ?: throw NoSuchElementException()

            user.username = userRequest.username
            user.passwordHash = userRequest.passwordHash

            call.respond(HttpStatusCode.Created)
        }
    }
    post("/create-login-link") {
        log.debug(call.request.headers.toMap().map { "${it.key}=${it.value}" }.joinToString("\n"))
        val body = call.receiveNullable<String>() ?: throw IllegalArgumentException("name parameter is required");
        val request = Json.decodeFromString<CreateLoginLinkRequest>(body)
        if (request.name.isBlank()) throw IllegalArgumentException("name parameter is required");

        lateinit var loginLink: LoginLink;
        withDatabase {
            val user = User {
                name = request.name
            }
            database.users.add(user)

            loginLink = LoginLink {
                token = UUID.randomUUID().toString()
                userId = user.id
            }
            database.loginLinks.add(loginLink)
            log.debug(loginLink.toString())
            call.respond(loginLink)
        }
    }
}

@Serializable
data class CreateLoginLinkRequest(var name: String)