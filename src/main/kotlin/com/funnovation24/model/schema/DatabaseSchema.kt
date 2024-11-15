package com.funnovation24.model.schema

import com.funnovation24.plugins.withDatabase
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseSchema(database: Database) {
    init {
        transaction(database) {
            SchemaUtils.create(Users)
            SchemaUtils.create(Teams)
            SchemaUtils.create(TeamAdmins)
            SchemaUtils.create(Competitions)
            SchemaUtils.create(CompetitionTeams)
            SchemaUtils.create(Matches)
            SchemaUtils.create(MatchSets)
            SchemaUtils.create(LoginLinks)
        }
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}

class DatabaseSchemaContext(val database: Database, val databaseSchema: DatabaseSchema)

inline fun <T : Any> withDatabaseSchema(body: DatabaseSchemaContext.() -> T): T {
    withDatabase {
        return body(DatabaseSchemaContext(database = database, DatabaseSchema(database)))
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