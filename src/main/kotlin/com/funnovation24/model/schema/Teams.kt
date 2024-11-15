package com.funnovation24.model.schema

import com.funnovation24.model.Team
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Teams : Table<Team>("team") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
}

val Database.teams get() = this.sequenceOf(Teams);