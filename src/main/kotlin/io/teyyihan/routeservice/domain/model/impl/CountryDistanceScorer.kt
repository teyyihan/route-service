package io.teyyihan.routeservice.domain.model.impl

import io.teyyihan.routeservice.domain.model.abstraction.Scorer
import kotlin.math.*

class CountryDistanceScorer: Scorer<Country> {

    override fun computeCost(from: Country, to: Country): Double {
        val radiusOfEarth = 6372.8

        val dLat = Math.toRadians(to.coordinate.lat - from.coordinate.lat)
        val dLon = Math.toRadians(to.coordinate.lon - from.coordinate.lon)
        val lat1 = Math.toRadians(from.coordinate.lat)
        val lat2 = Math.toRadians(to.coordinate.lat)

        val a = sin(dLat / 2).pow(2.0) + sin(dLon / 2).pow(2.0) * cos(lat1) * cos(lat2)
        val c = 2 * asin(sqrt(a))
        return radiusOfEarth * c
    }

}