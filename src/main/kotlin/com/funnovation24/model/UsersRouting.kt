package com.funnovation24.model

import io.ktor.server.routing.*

fun Routing.usersRouting() {
    get("/users") {
//        withDatabaseSchema {
//            databaseSchema.dbQuery {
//                Users
//                    .join(Teams, JoinType.INNER)
//                    .join(TeamAdmins, JoinType.LEFT)
//                    .selectAll()
//                    .map {
//                        User(
//                            id = it[Users.id],
//                            name = it[Users.name],
//                            username = it[Users.username],
//                            email = it[Users.email],
//                            passwordHash = it[Users.passwordHash],
//                            superAdmin = it[Users.superAdmin],
//                            team = Team(
//                                id = it[Teams.id],
//                                name = it[Teams.name],
//
//                            )
//                        )
//                    }
//            }
//        }
    }

//    // Create user
//    post("/users") {
//        val user = call.receive<ExposedUser>()
//        withDatabaseSchema {
//            val id = databaseSchema.create(user)
//            call.respond(HttpStatusCode.Created, id)
//        }
//    }
//
//    // Read user
//    get("/users/{id}") {
//        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
//        withDatabaseSchema {
//            val user = databaseSchema.read(id)
//            if (user != null) {
//                call.respond(HttpStatusCode.OK, user)
//            } else {
//                call.respond(HttpStatusCode.NotFound)
//            }
//        }
//    }
//
//    // Update user
//    put("/users/{id}") {
//        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
//        val user = call.receive<ExposedUser>()
//        withDatabaseSchema {
//            databaseSchema.update(id, user)
//            call.respond(HttpStatusCode.OK)
//        }
//    }
//
//    // Delete user
//    delete("/users/{id}") {
//        val id = call.parameters["id"]?.toInt() ?: throw IllegalArgumentException("Invalid ID")
//        withDatabaseSchema {
//            databaseSchema.delete(id)
//            call.respond(HttpStatusCode.OK)
//        }
//    }
}