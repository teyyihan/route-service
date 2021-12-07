package io.teyyihan.routeservice.domain.model.impl

import io.teyyihan.routeservice.domain.model.Coordinate
import io.teyyihan.routeservice.domain.model.abstraction.GraphNode

class Country(
    private val id: String,
    val coordinate: Coordinate,
): GraphNode {

    override fun getId(): String = id

}