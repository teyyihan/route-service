package io.teyyihan.routeservice.domain.exception

class NoNodeFoundException(id: String): IllegalStateException("No node is found with id: $id")