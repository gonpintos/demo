package com.ultrasoft.demo.repository

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("customer")
data class CustomerEntity(
    val id: Long? = null,
    val email: String,
    val password: String,
    @CreatedDate
    val createdAt: LocalDateTime? = null
)
