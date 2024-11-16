package com.funnovation24.plugins

import com.funnovation24.controllers.registerRouting
import com.funnovation24.controllers.usersRouting
import com.funnovation24.security.UnautorizedException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.apache.commons.logging.LogFactory
import java.io.File

val errorLog = LogFactory.getLog("Error");

fun Application.configureRouting() {
    val staticResourceFolder = File(javaClass.classLoader.getResource("static")!!.file)

    install(Resources)
    install(StatusPages) {
        exception<NoSuchElementException> { call, cause ->
            call.respond(HttpStatusCode.NotFound)
        }
        exception<IllegalArgumentException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, cause.message ?: "")
        }
        exception<UnautorizedException> { call, cause ->
            call.respond(HttpStatusCode.Unauthorized, cause.message ?: "")
        }
        exception<Throwable> { call, cause ->
            errorLog.error("Internal Server Error", cause);
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
//        status(HttpStatusCode.NotFound) { call, status ->
//            call.respondFile(staticResourceFolder, "${status.value}.html")
//        }
    }
    routing {
        route("/api") {
            registerRouting()
            usersRouting()
            get("{...}") {
                call.respondText("Hello from ${call.request.uri}")
            }
        }
        staticResources("vite.svg", "static", "vite.svg")
        staticResources("/assets", "static/assets")
        get("{...}") {
            call.respondFile(staticResourceFolder, "index.html")
        }
    }
}

