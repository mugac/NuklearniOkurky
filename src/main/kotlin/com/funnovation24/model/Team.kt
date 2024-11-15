package com.funnovation24.model

import org.ktorm.entity.Entity

interface Team : Entity<Team> {
    companion object : Entity.Factory<Team>()

    val id: Int
    val name: String
    val admins: Set<User>
}