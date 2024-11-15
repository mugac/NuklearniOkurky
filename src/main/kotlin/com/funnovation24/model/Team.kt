package com.funnovation24.model

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: Int,
    val name: String,
)