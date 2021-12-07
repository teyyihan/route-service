package io.teyyihan.routeservice.domain.model

import io.teyyihan.routeservice.domain.exception.NoEdgeFoundException
import io.teyyihan.routeservice.domain.exception.NoNodeFoundException
import io.teyyihan.routeservice.domain.model.abstraction.GraphNode


class Graph<T : GraphNode>(
    private val nodes: Set<T> = mutableSetOf(),
    private val edges: Map<String, Set<String>> = mutableMapOf(),
) {

    fun getNode(id: String): T = nodes
        .firstOrNull { node: T -> node.getId() == id } ?: throw NoNodeFoundException(id)

    fun getEdges(node: T): Set<T> {
        val edgesOfNode =
            edges[node.getId()] ?: throw NoEdgeFoundException(node.getId())

        return edgesOfNode
            .map { id: String -> getNode(id) }
            .toSet()
    }

}