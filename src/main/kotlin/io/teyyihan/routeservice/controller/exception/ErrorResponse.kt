package io.teyyihan.routeservice.controller.exception

class ErrorResponse(
    val exception: String? = "",
    val timestamp: Long = System.currentTimeMillis(),
)
