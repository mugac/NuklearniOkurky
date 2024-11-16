package com.funnovation24.database.schema

import com.funnovation24.database.model.TeamAdmin
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int

object TeamAdmins : Table<TeamAdmin>("team_admin") {
    val teamId = int("team_id").primaryKey().bindTo { it.teamId }
    val userId = int("user_id").primaryKey().bindTo { it.userId }
}

val Database.teamAdmins get() = this.sequenceOf(TeamAdmins);