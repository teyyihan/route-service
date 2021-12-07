package io.teyyihan.routeservice.controller.response

import io.teyyihan.routeservice.domain.model.impl.Country

data class RoutingResponse(
    val route: List<String>
) {

    companion object {
        fun from(countries: List<Country>) = RoutingResponse(
            route = countries.map { it.getId() }
        )
    }

}