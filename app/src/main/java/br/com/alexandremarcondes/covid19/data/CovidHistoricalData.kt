package br.com.alexandremarcondes.covid19.data

import java.util.*

data class CovidHistoricalData(
    val id: Int,
    val date: Date?,
    val mainland_china_cases: Int,
    val other_locations_cases: Int,
    val delta_confirmed: Int,
    val delta_recovered: Int,
    val total_confirmed: Int,
    val total_recovered: Int,
    val date_string: String
)