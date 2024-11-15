package com.funnovation24.model

import org.ktorm.entity.Entity

interface LoginLink : Entity<LoginLink> {
    companion object : Entity.Factory<LoginLink>()

    val token: String;
    val userId: Int;
    val user: User;
}