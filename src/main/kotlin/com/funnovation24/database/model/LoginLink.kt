package com.funnovation24.database.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface LoginLink : Entity<LoginLink> {
    companion object : Entity.Factory<LoginLink>()

    var token: String;
    var userId: Int;
}