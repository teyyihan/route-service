package io.teyyihan.routeservice.domain.exception

class NoRouteFoundException(from: String, to: String) : IllegalStateException("No route found from: $from to: $to")