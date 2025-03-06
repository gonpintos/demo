package com.ultrasoft.demo.controller

import java.time.LocalDateTime

data class CustomerDto(
    val email: String,
    val password: String,
    val createdAt: LocalDateTime? = null
)
