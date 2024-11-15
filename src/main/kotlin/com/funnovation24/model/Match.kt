package com.funnovation24.model

import kotlinx.serialization.Serializable

@Serializable
data class Match(
    val id: Int,
    val competition: Competition,
    val hostTeam: CompetitionTeam,
    val guestTeam: CompetitionTeam,
    val status: MatchStatus,
)

