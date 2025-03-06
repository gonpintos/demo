package com.ultrasoft.demo.controller

import com.ultrasoft.demo.service.CustomerService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class CustomerHandler(
    private val customerService: CustomerService
) {
    fun createCustomer(serverRequest: ServerRequest): Mono<ServerResponse> =
        serverRequest.bodyToMono(CustomerDto::class.java)
            .flatMap { customerDto ->
                customerService.createCustomer(customerDto.email, customerDto.password)
            }
            .flatMap { customer ->
                ServerResponse.ok()
                    .bodyValue(
                        CustomerDto(
                            email = customer.email,
                            password = customer.password,
                            createdAt = customer.createdAt
                        )
                    )
            }

    fun getCustomer(serverRequest: ServerRequest): Mono<ServerResponse> =
        customerService.getCustomer(serverRequest.pathVariable("email"))
            .flatMap { customer ->
                ServerResponse.ok()
                    .bodyValue(
                        CustomerDto(
                            email = customer.email,
                            password = customer.password,
                            createdAt = customer.createdAt
                        )
                    )
            }
}