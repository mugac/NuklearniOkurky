package com.funnovation24.model

import kotlinx.serialization.Serializable

@Serializable
data class MatchSet(
    val id: Int,
    val match: Match,
    val hostScore: Int,
    val guestScore: Int,
)

