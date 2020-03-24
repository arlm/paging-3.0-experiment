package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class Attributes (
    @SerializedName("OBJECTID") val oBJECTID : Int,
    @SerializedName("Province_State") val province_State : String,
    @SerializedName("Country_Region") val country_Region : String,
    @SerializedName("Last_Update") val last_Update : Int,
    @SerializedName("Lat") val lat : Double,
    @SerializedName("Long_") val long_ : Double,
    @SerializedName("Confirmed") val confirmed : Int,
    @SerializedName("Recovered") val recovered : Int,
    @SerializedName("Deaths") val deaths : Int,
    @SerializedName("Active") val active : Int,
    @SerializedName("Admin2") val admin2 : String,
    @SerializedName("FIPS") val fIPS : String,
    @SerializedName("Combined_Key") val combined_Key : String
)