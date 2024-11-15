package com.funnovation24.model

import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.usersRouting() {
    // Create user
    post("/users") {
        val user = call.receive<ExposedUser>()
        withUserService {
            val id = databaseSchema.create(user)
            call.respond(HttpStatusCode.Created, id)
        }
    }

    // Read user
    get("/users/{id}") {
        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
        withUserService {
            val user = databaseSchema.read(id)
            if (user != null) {
                call.respond(HttpStatusCode.OK, user)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
    }

    // Update user
    put("/users/{id}") {
        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
        val user = call.receive<ExposedUser>()
        withUserService {
            databaseSchema.update(id, user)
            call.respond(HttpStatusCode.OK)
        }
    }

    // Delete user
    delete("/users/{id}") {
        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
        withUserService {
            databaseSchema.delete(id)
            call.respond(HttpStatusCode.OK)
        }
    }
}