package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class SpatialReference (
    @SerializedName("wkid") val wkid : Int,
    @SerializedName("latestWkid") val latestWkid : Int
)