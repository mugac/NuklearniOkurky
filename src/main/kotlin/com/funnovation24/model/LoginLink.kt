package com.funnovation24.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface LoginLink : Entity<LoginLink> {
    companion object : Entity.Factory<LoginLink>()

    var token: String;
    var userId: Int;
    val user: User;
}