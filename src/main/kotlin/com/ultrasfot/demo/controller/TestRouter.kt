package com.ultrasfot.demo.controller

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class TestRouter {
    @Bean
    fun test(testHandler: TestHandler): RouterFunction<ServerResponse> =
        RouterFunctions.route(
            RequestPredicates.POST("/test")
                .and(RequestPredicates.contentType(APPLICATION_JSON))
                .and(RequestPredicates.accept(APPLICATION_JSON)),
            testHandler::testGreetings
        )
}