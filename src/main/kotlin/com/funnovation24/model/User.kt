package com.funnovation24.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val team: Team,
    val name: String,
    val username: String,
    val email: String?,
    val passwordHash: String?,
    val superAdmin: Boolean,
)