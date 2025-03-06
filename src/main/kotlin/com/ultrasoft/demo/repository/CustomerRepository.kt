package com.ultrasoft.demo.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CustomerRepository: ReactiveCrudRepository<CustomerEntity, Long> {
    fun findByEmail(email: String): Mono<CustomerEntity>
}