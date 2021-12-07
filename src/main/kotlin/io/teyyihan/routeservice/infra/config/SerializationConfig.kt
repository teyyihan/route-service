package io.teyyihan.routeservice.infra.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@Configuration
class SerializationConfig {

    @Bean
    fun objectMapper(): ObjectMapper = Jackson2ObjectMapperBuilder()
        .build<ObjectMapper>()

}