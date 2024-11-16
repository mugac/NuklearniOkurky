package com.funnovation24.database.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface Match : Entity<Match> {
    companion object : Entity.Factory<Match>()

    val id: Int;
    val hostTeamId: Int
    val hostTeam: Team;
    val guestTeamId: Int
    val guestTeam: Team;
    var statusString: String;
    var status: MatchStatus
        get() = MatchStatus.valueOf(statusString)
        set(value) {
            statusString = value.name
        }

    val sets: Set<MatchSet>;
}