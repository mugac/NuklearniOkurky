package com.funnovation24.model

import kotlinx.serialization.Serializable

@Serializable
data class CompetitionTeam(
    val competition: Competition,
    val team: Team,
    val division: String,
)