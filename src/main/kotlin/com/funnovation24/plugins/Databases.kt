package com.funnovation24.plugins

import io.ktor.server.application.*
import org.ktorm.database.Database

@PublishedApi
internal lateinit var database: Database;

class DatabaseContext(val database: Database)

inline fun <T : Any> withDatabase(body: DatabaseContext.() -> T): T {
    return body(DatabaseContext(database = database))
}

fun Application.configureDatabases() {
    database = connectToMariaDb()
}

fun Application.connectToMariaDb(): Database {
    val user = System.getenv("DB_USER") ?: "nuklearniuser"
    val password = System.getenv("DB_PASSWORD") ?: "P7x5kMScw"
//    val host = System.getenv("DB_HOST") ?: "10.128.40.90"
//    val port = System.getenv("DB_PORT") ?: "3306"
    val host = System.getenv("DB_HOST") ?: "10.128.40.94"
    val port = System.getenv("DB_PORT") ?: "55712"
    val dbName = System.getenv("DB_NAME") ?: "nuklearni_okurky"

    //  jdbc:mariadb://HOST:PORT/DBNAME
    val connection = Database.connect(
        url = "jdbc:mariadb://$host:$port/$dbName",
        driver = "org.mariadb.jdbc.Driver",
        user = user,
        password = password ?: "",
    )

    return connection
}

