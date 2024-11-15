package com.funnovation24.model

import com.funnovation24.plugins.withDatabase
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseSchema(database: Database) {
    object Users : Table(name = "user") {
        val id = integer("id").autoIncrement()
        val teamId = integer("team_id") references Team.id
        val name = varchar("name", length = 50)
        val username = varchar("username", length = 50)
        val email = varchar("varchar", length = 255)
        val passwordHash = varchar("varchar", length = 255)
        val superAdmin = bool("super_admin")

        override val primaryKey = PrimaryKey(id)
    }

    object Team : Table(name = "team") {
        val id = integer("id").autoIncrement()
        val name = varchar("name", length = 50)

        override val primaryKey = PrimaryKey(id)
    }

    object TeamAdmin : Table(name = "team_admin") {
        val teamId = integer("team_id") references Team.id
        val userId = integer("user_id") references Users.id

        override val primaryKey = PrimaryKey(teamId, userId)
    }

    object Competition : Table(name = "competition") {
        val id = integer("id").autoIncrement()
        val name = varchar("name", length = 50)
        val year = integer("year")

        override val primaryKey = PrimaryKey(id)
    }

    object CompetitionTeam : Table(name = "competition_team") {
        val competitionId = integer("competition_id") references Competition.id
        val teamId = integer("team_id") references Team.id
        val division = varchar("division", length = 50)

        override val primaryKey = PrimaryKey(competitionId, teamId)
    }

    object Match : Table(name = "match") {
        val id = integer("id").autoIncrement()
        val competitionId = integer("competition_id") references Competition.id
        val hostTeamId = integer("host_team_id") references CompetitionTeam.teamId
        val guestTeamId = integer("guest_team_id") references CompetitionTeam.teamId
        val status = varchar("status", length = 50)

        override val primaryKey = PrimaryKey(id)
    }

    object MatchSet : Table(name = "match_set") {
        val id = integer("id").autoIncrement()
        val matchId = integer("match_id") references Match.id
        val hostScore = integer("host_score")
        val guestScore = integer("guest_score")

        override val primaryKey = PrimaryKey(id)
    }

    init {
        transaction(database) {
            SchemaUtils.create(Users)
        }
    }

//    suspend fun create(user: ExposedUser): Int = dbQuery {
//        Users.insert {
//            it[name] = user.name
//            it[age] = user.age
//        }[Users.id]
//    }
//
//    suspend fun read(id: Int): ExposedUser? {
//        return dbQuery {
//            Users.selectAll()
//                .where { Users.id eq id }
//                .map { ExposedUser(it[Users.name], it[Users.age]) }
//                .singleOrNull()
//        }
//    }
//
//    suspend fun update(id: Int, user: ExposedUser) {
//        dbQuery {
//            Users.update({ Users.id eq id }) {
//                it[name] = user.name
//                it[age] = user.age
//            }
//        }
//    }
//
//    suspend fun delete(id: Int) {
//        dbQuery {
//            Users.deleteWhere { Users.id.eq(id) }
//        }
//    }
}

class UserServiceContext(val database: Database, val databaseSchema: DatabaseSchema)

inline fun <T : Any> withUserService(body: UserServiceContext.() -> T): T {
    withDatabase {
        return body(UserServiceContext(database = database, DatabaseSchema(database)))
    }
}