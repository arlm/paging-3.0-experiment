package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class Fields (
    @SerializedName("name") val name : String,
    @SerializedName("type") val type : String,
    @SerializedName("alias") val alias : String,
    @SerializedName("sqlType") val sqlType : String,
    @SerializedName("domain") val domain : String,
    @SerializedName("defaultValue") val defaultValue : String
)