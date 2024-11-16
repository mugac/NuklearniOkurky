package com.funnovation24.controllers

import com.funnovation24.database.schema.matches
import com.funnovation24.database.schema.teams
import com.funnovation24.database.schema.users
import com.funnovation24.plugins.withDatabase
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.entity.toList

fun Route.usersRouting() {
    get("/users") {
        withDatabase {
            call.respond(database.users.toList());
        }
    }
    get("/teams") {
        withDatabase {
            call.respond(database.teams.toList());
        }
    }
    get("/matches") {
        withDatabase {
            call.respond(database.matches.toList());
        }
    }
}