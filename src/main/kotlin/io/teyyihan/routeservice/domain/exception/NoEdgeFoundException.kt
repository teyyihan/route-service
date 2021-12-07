package io.teyyihan.routeservice.domain.exception

class NoEdgeFoundException(id: String): IllegalStateException("No edge found for node with id: $id")