package io.teyyihan.routeservice.domain.model.abstraction

import io.teyyihan.routeservice.domain.exception.NoRouteFoundException
import io.teyyihan.routeservice.domain.model.Graph
import java.util.*


open class RouteFinder<T : GraphNode>(
    private val graph: Graph<T>,
    private val nextNodeScorer: Scorer<T>,
    private val targetScorer: Scorer<T>,
) {

    fun findRoute(fromId: String, toId: String): List<T> {

        val from = graph.getNode(fromId)
        val to = graph.getNode(toId)

        val allNodes: MutableMap<T, RouteNode<T>> = HashMap()
        val openSet: Queue<RouteNode<T>> = PriorityQueue()

        val start = RouteNode(from, null, 0.0, targetScorer.computeCost(from, to))
        allNodes[from] = start
        openSet.add(start)

        while (!openSet.isEmpty()) {
            val next: RouteNode<T> = openSet.poll()
            if (next.current == to) {
                val route: MutableList<T> = ArrayList()
                var current: RouteNode<T>? = next
                do {
                    route.add(0, current!!.current)
                    current = allNodes[current.previous]
                } while (current != null)
                return route
            }

            graph.getEdges(next.current).forEach { edge ->
                val newScore: Double = next.routeScore + nextNodeScorer.computeCost(next.current, edge)
                val nextNode = allNodes.getOrDefault(edge, RouteNode(edge))
                allNodes[edge] = nextNode
                if (nextNode.routeScore > newScore) {
                    nextNode.previous = next.current
                    nextNode.routeScore = newScore
                    nextNode.estimatedScore = newScore + targetScorer.computeCost(edge, to)
                    openSet.add(nextNode)
                }
            }
        }

        throw NoRouteFoundException(fromId, toId)
    }

}