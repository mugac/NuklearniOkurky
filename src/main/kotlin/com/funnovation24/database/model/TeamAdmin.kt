package com.funnovation24.database.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface TeamAdmin : Entity<TeamAdmin> {
    companion object : Entity.Factory<TeamAdmin>()

    val teamId: Int;
    val userId: Int;
}