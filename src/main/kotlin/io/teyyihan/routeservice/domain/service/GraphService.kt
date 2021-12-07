package io.teyyihan.routeservice.domain.service

import io.teyyihan.routeservice.domain.model.abstraction.GraphNode
import io.teyyihan.routeservice.domain.model.abstraction.RouteFinder

abstract class GraphService<T: GraphNode>(
    private val routeFinder: RouteFinder<T>,
) {

    fun findRoute(from: String, to: String): List<T> {
        return routeFinder.findRoute(from, to)
    }

}