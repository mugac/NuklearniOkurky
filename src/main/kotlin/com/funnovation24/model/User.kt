package com.funnovation24.model

import org.ktorm.entity.Entity

interface User : Entity<User> {
    companion object : Entity.Factory<User>()

    val id: Int;
    val teamId: Int;
    val team: Team;
    val name: String;
    val username: String;
    val email: String?;
    val passwordHash: String?;
    val superAdmin: Boolean;
}