package io.teyyihan.routeservice.domain.model.abstraction

data class RouteNode<T : GraphNode> constructor(
    val current: T,
    var previous: T? = null,
    var routeScore: Double = Double.POSITIVE_INFINITY,
    var estimatedScore: Double = Double.POSITIVE_INFINITY
): Comparable<RouteNode<T>> {

    override fun compareTo(other: RouteNode<T>): Int {
        return if (this.estimatedScore > other.estimatedScore) {
            1
        } else if (this.estimatedScore < other.estimatedScore) {
            -1
        } else {
            0
        }
    }
}