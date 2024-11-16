package com.funnovation24.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureHTTP() {
    install(Compression)
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        exposeHeader(HttpHeaders.AccessControlAllowOrigin)
        anyHost()
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
        header("Access-Control-Allow-Origin", "*")
        header("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, HEAD, OPTIONS")
    }
    routing {
        swaggerUI(path = "openapi")
    }
}
