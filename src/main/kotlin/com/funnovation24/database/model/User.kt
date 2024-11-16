package com.funnovation24.database.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface User : Entity<User> {
    companion object : Entity.Factory<User>()

    val id: Int;
    val teamId: Int?;
    var name: String;
    var username: String?;
    var email: String?;
    var passwordHash: String?;
    var superAdmin: Boolean;
}