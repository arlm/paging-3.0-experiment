package br.com.alexandremarcondes.covid19.data

import java.util.*

data class CovidData(
    val id: Int,
    val country: String,
    val region: String,
    val county: String?,
    val date: Date,
    val cases: Int,
    val deaths: Int,
    val recoveries: Int,
    val activeCases: Int
)