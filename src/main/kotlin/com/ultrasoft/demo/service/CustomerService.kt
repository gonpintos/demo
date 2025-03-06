package com.ultrasoft.demo.service

import com.ultrasoft.demo.repository.CustomerRepository
import com.ultrasoft.demo.model.Customer
import com.ultrasoft.demo.repository.CustomerEntity
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {

    fun getCustomer(email: String): Mono<Customer> =
        customerRepository.findByEmail(email)
            .map { customerEntity ->
                Customer(
                    email = customerEntity.email,
                    password = customerEntity.password,
                    createdAt = customerEntity.createdAt
                )
            }

    fun createCustomer(email: String, password: String): Mono<Customer> =
        customerRepository.save(
            CustomerEntity(
                email = email,
                password = password
            )
        )
            .map { customerEntity ->
                Customer(
                    email = customerEntity.email,
                    password = customerEntity.password,
                    createdAt = customerEntity.createdAt
                )
            }
}