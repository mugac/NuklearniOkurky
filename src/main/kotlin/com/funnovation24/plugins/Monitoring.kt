package com.funnovation24.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*

fun Application.configureMonitoring() {
    install(CallLogging) {
        format { call ->
            val status = call.response.status()
            val httpMethod = call.request.httpMethod.value
            val uri = call.request.uri
            val time = call.processingTimeMillis()
            val userAgent = call.request.headers["User-Agent"]
            val ip = call.request.origin.remoteAddress;

            "$httpMethod $uri ($status) in ${time}ms, From $ip, User agent: $userAgent"
        }
    }
//    install(KHealth)
//    install(CallId) {
//        header(HttpHeaders.XRequestId)
//        verify { callId: String ->
//            callId.isNotEmpty()
//        }
//    }
}
