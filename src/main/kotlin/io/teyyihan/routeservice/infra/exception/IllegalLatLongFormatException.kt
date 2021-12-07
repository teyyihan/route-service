package io.teyyihan.routeservice.infra.exception

class IllegalLatLongFormatException(latlng: List<Double>) : IllegalStateException("Lat long format is not correct: $latlng")