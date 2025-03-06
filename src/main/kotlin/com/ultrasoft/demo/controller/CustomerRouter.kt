package com.ultrasoft.demo.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.*


@Configuration
class CustomerRouter {
    @Bean
    fun test(customerHandler: CustomerHandler): RouterFunction<ServerResponse> =
        router {
            POST(
                pattern = "/customers",
                predicate = contentType(APPLICATION_JSON)
                    .and(accept(APPLICATION_JSON)),
                f = customerHandler::createCustomer
            )
            GET(
                pattern = "/customers/{email}",
                predicate = accept(APPLICATION_JSON),
                f = customerHandler::getCustomer
            )
        }
}