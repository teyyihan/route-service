package io.teyyihan.routeservice.domain.model.abstraction

interface Scorer<T : GraphNode> {
    fun computeCost(from: T, to: T): Double
}