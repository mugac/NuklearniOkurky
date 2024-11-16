package com.funnovation24.model

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity

@Serializable
sealed interface User : Entity<User> {
    companion object : Entity.Factory<User>()

    val id: Int;
    val teamId: Int?;
    val team: Team?;
    var name: String;
    var username: String;
    var email: String?;
    var passwordHash: String?;
    var superAdmin: Boolean;
}