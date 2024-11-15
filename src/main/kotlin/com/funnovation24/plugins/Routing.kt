package com.funnovation24.plugins

import com.funnovation24.model.usersRouting
import com.funnovation24.security.UnautorizedException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    val staticResourceFolder = File(javaClass.classLoader.getResource("static")!!.file)

    install(Resources)
    install(StatusPages) {
        exception<UnautorizedException> { call, cause ->
            call.respond(HttpStatusCode.Unauthorized, cause.message ?: "")
        }
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondFile(staticResourceFolder, "${status.value}.html")
        }
    }
    routing {
        route("/api") {
            usersRouting()
            get("{...}") {
                call.respondText("Hello from ${call.request.uri}")
            }
        }
        staticResources("/", "static")
        get("{...}") {
            call.respondFile(staticResourceFolder, "index.html")
        }
    }
}

