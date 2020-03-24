package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class UniqueIdField (
    @SerializedName("name") val name : String,
    @SerializedName("isSystemMaintained") val isSystemMaintained : Boolean
)