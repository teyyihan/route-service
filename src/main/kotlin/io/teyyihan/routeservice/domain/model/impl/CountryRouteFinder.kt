package io.teyyihan.routeservice.domain.model.impl

import io.teyyihan.routeservice.domain.model.Graph
import io.teyyihan.routeservice.domain.model.abstraction.RouteFinder
import io.teyyihan.routeservice.domain.model.abstraction.Scorer

class CountryRouteFinder(
    private val graph: Graph<Country>,
    private val scorer: Scorer<Country>,
): RouteFinder<Country>(graph, scorer, scorer)