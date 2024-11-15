package com.funnovation24.plugins

import com.funnovation24.model.usersRouting
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
    install(Resources)
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondFile(File(javaClass.classLoader.getResource("static/404.html")!!.file))
        }
    }
    routing {
        staticResources("/", "static")
        route("/api") {
            usersRouting()
            get("{...}") {
                call.respondText("Hello from ${call.request.uri}")
            }
        }
    }
}

