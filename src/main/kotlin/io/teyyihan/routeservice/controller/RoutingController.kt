package io.teyyihan.routeservice.controller

import io.teyyihan.routeservice.controller.response.RoutingResponse
import io.teyyihan.routeservice.domain.service.CountryGraphService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/routing")
class RoutingController(
    private val countryGraphService: CountryGraphService
) {

    @GetMapping("/{origin}/{destination}")
    fun getRoute(
        @PathVariable origin: String,
        @PathVariable destination: String,
    ): RoutingResponse {
        val countriesOfRoute = countryGraphService.findRoute(origin, destination)
        return RoutingResponse.from(countriesOfRoute)
    }

}