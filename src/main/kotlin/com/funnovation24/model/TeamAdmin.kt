package com.funnovation24.model

import org.ktorm.entity.Entity

interface TeamAdmin : Entity<TeamAdmin> {
    companion object : Entity.Factory<TeamAdmin>()

    val teamId: Int;
    val userId: Int;
}