package com.funnovation24.plugins

import com.funnovation24.util.serializer.LocalDateSerializer
import com.funnovation24.util.serializer.LocalDateTimeSerializer
import com.funnovation24.util.serializer.LocalTimeSerializer
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(Json {
            serializersModule = SerializersModule {
                contextual(LocalDate::class, LocalDateSerializer)
                contextual(LocalDateTime::class, LocalDateTimeSerializer)
                contextual(LocalTime::class, LocalTimeSerializer)
            }
        })
    }
//    routing {
//        get("/json/kotlinx-serialization") {
//            call.respond(mapOf("hello" to "world"))
//        }
//    }
}
