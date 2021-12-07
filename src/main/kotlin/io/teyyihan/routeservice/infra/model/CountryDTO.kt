package io.teyyihan.routeservice.infra.model

import io.teyyihan.routeservice.domain.model.Coordinate
import io.teyyihan.routeservice.domain.model.impl.Country
import io.teyyihan.routeservice.infra.exception.IllegalLatLongFormatException

data class CountryDTO(
    val cca3: String,
    val latlng: List<Double>,
    val borders: List<String>,
) {

    fun toDomain(): Country {
        if (latlng.size != 2) throw IllegalLatLongFormatException(latlng)

        return Country(
            id = cca3,
            coordinate = Coordinate(
                lat = latlng[0],
                lon = latlng[1],
            )
        )
    }

}