package com.funnovation24.database.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface Team : Entity<Team> {
    companion object : Entity.Factory<Team>()

    val id: Int
    var name: String
    val admins: Set<User>
}