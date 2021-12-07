package io.teyyihan.routeservice.domain.service

import io.teyyihan.routeservice.domain.model.Graph
import io.teyyihan.routeservice.domain.model.impl.Country
import io.teyyihan.routeservice.domain.model.impl.CountryDistanceScorer
import io.teyyihan.routeservice.domain.model.impl.CountryRouteFinder
import org.springframework.context.annotation.DependsOn
import org.springframework.stereotype.Service

@DependsOn("graph")
@Service
class CountryGraphService(
    graph: Graph<Country>,
) : GraphService<Country>(CountryRouteFinder(graph, CountryDistanceScorer()))