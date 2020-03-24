package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class Error (
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("details") val details : List<String>
)