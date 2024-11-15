package com.funnovation24.model.schema

import com.funnovation24.model.User
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Users : Table<User>("user") {
    val id = int("id").primaryKey().bindTo { it.id }
    val teamId = int("team_id").bindTo { it.teamId }
    val name = varchar("name").bindTo { it.name }
    val username = varchar("username").bindTo { it.username }
    val email = varchar("varchar").bindTo { it.email }
    val passwordHash = varchar("varchar").bindTo { it.passwordHash }
    val superAdmin = boolean("super_admin").bindTo { it.superAdmin }
}

val Database.users get() = this.sequenceOf(Users);