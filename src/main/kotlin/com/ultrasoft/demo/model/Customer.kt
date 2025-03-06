package com.ultrasoft.demo.model

import java.time.LocalDateTime

data class Customer(
    val email: String,
    val password: String,
    val createdAt: LocalDateTime? = null,
)
