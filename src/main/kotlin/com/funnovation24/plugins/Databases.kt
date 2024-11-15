package com.funnovation24.plugins

import io.ktor.server.application.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

@PublishedApi
internal lateinit var database: Database;

class DatabaseContext(val database: Database)

inline fun <T : Any> withDatabase(body: DatabaseContext.() -> T): T {
    return body(DatabaseContext(database = database))
}

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }

fun Application.configureDatabases() {
    database = connectToMariaDb()
}

fun Application.connectToMariaDb(): Database {
    val user = System.getenv("DB_USER")
    val password = System.getenv("DB_PASSWORD")
    val host = System.getenv("DB_HOST") ?: "127.0.0.1"
    val port = System.getenv("DB_PORT") ?: "3306"
    val dbName = System.getenv("DB_NAME") ?: "nuklearni_okurky"

    //  jdbc:mariadb://HOST:PORT/DBNAME
    val connection = Database.connect(
        url = "jdbc:mariadb://$host:$port/$dbName",
        user = user ?: "root",
        password = password ?: "",
    )

    return connection
}

