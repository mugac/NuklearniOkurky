package com.funnovation24.database.schema

import com.funnovation24.database.model.MatchSet
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int


object MatchSets : Table<MatchSet>("match_set") {
    val id = int("id").primaryKey().bindTo { it.id }
    val matchId = int("match_id").bindTo { it.matchId }
    val hostScore = int("host_score").bindTo { it.hostScore }
    val guestScore = int("guest_score").bindTo { it.guestScore }
}

val Database.matchSets get() = this.sequenceOf(MatchSets);