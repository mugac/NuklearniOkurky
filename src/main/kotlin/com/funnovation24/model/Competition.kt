package com.funnovation24.model

import kotlinx.serialization.Serializable

@Serializable
data class Competition(
    val id: Int,
    var name: String,
    var year: Int,
    val teams: Set<CompetitionTeam> = setOf(),
)