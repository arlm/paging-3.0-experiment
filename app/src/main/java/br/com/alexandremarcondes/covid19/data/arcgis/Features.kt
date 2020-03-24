package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class Features (
    @SerializedName("attributes") val attributes : Attributes
)