package io.teyyihan.routeservice.infra.service

import com.fasterxml.jackson.databind.ObjectMapper
import io.teyyihan.routeservice.domain.model.Graph
import io.teyyihan.routeservice.domain.model.impl.Country
import io.teyyihan.routeservice.infra.model.CountryDTO
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import org.springframework.util.ResourceUtils

@Component
class GraphService(
    private val objectMapper: ObjectMapper
) {

    @Bean("graph")
    fun getGraph(): Graph<Country> {
        val edges = mutableMapOf<String, Set<String>>()

        val countryDTOs = objectMapper.readValue<List<CountryDTO>>(
            ClassPathResource("countries.json").inputStream,
            objectMapper.typeFactory.constructCollectionType(
                List::class.java, CountryDTO::class.java
            )
        )

        val countries = countryDTOs.map {
            edges[it.cca3] = it.borders.toSet()
            it.toDomain()
        }.toSet()

        return Graph(countries, edges)
    }

}