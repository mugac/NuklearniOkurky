package com.funnovation24.database.schema

import com.funnovation24.database.model.LoginLink
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object LoginLinks : Table<LoginLink>("login_link") {
    val token = varchar("token").primaryKey().bindTo { it.token }
    val userId = int("user_id").bindTo { it.userId }
}

val Database.loginLinks get() = this.sequenceOf(LoginLinks);