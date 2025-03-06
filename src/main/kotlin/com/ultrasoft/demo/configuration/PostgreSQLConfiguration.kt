package com.ultrasoft.demo.configuration

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration

@Configuration
class PostgreSQLConfiguration: AbstractR2dbcConfiguration() {

    @Value("\${db.postgresql.host}")
    private lateinit var host: String

    @Value("\${db.postgresql.port}")
    private var port: Int = 5432

    @Value("\${db.postgresql.db}")
    private lateinit var db : String

    @Value("\${db.postgresql.schema}")
    private lateinit var schema : String

    @Value("\${db.postgresql.username}")
    private lateinit var username : String

    @Value("\${db.postgresql.password}")
    private lateinit var password : String

    @Bean
    override fun connectionFactory(): ConnectionFactory =
        PostgresqlConnectionFactory(
            PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .database(db)
                .username(username)
                .password(password)
                .schema(schema)
                //.enableSsl()
                .build()
        )
}