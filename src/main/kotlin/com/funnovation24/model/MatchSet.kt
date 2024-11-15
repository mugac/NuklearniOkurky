package com.funnovation24.model

import org.ktorm.entity.Entity

interface MatchSet : Entity<MatchSet> {
    companion object : Entity.Factory<MatchSet>()

    val id: Int;
    val matchId: Int;
    val match: Match;
    val hostScore: Int;
    val guestScore: Int;
}
