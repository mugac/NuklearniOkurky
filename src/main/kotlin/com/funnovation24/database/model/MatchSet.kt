package com.funnovation24.database.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface MatchSet : Entity<MatchSet> {
    companion object : Entity.Factory<MatchSet>()

    val id: Int;
    val matchId: Int;
    val match: Match;
    val hostScore: Int;
    val guestScore: Int;
}