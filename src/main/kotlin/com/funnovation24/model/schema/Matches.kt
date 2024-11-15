package com.funnovation24.model.schema

import com.funnovation24.model.Match
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Matches : Table<Match>("match") {
    val id = int("id").primaryKey().bindTo { it.id }
    val hostTeamId = int("host_team_id").bindTo { it.hostTeamId }
    val guestTeamId = int("guest_team_id").bindTo { it.guestTeamId }
    val status = varchar("status").bindTo { it.statusString }
}

val Database.matches get() = this.sequenceOf(Matches);
