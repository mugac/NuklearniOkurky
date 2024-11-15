package com.funnovation24.model

import org.ktorm.entity.Entity

interface Match : Entity<Match> {
    companion object : Entity.Factory<Match>()

    val id: Int;
    val hostTeamId: Int
    val hostTeam: Team;
    val guestTeamId: Int
    val guestTeam: Team;
    var status: MatchStatus;
    var statusString: String
        get() = status.name
        set(value) {
            status = MatchStatus.valueOf(value)
        }
    val sets: Set<MatchSet>;
}

