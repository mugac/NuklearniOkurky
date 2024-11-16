package com.funnovation24.plugins

import com.fasterxml.jackson.databind.ObjectMapper
import com.funnovation24.util.serializer.LocalDateSerializer
import com.funnovation24.util.serializer.LocalDateTimeSerializer
import com.funnovation24.util.serializer.LocalTimeSerializer
import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.ktorm.jackson.KtormModule
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        register(
            ContentType.Application.Json, JacksonConverter(
                ObjectMapper().registerModule(KtormModule())
            )
        )
        json(Json {
            serializersModule = SerializersModule {
                contextual(LocalDate::class, LocalDateSerializer)
                contextual(LocalDateTime::class, LocalDateTimeSerializer)
                contextual(LocalTime::class, LocalTimeSerializer)
            }
        })
    }
    routing {
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}
