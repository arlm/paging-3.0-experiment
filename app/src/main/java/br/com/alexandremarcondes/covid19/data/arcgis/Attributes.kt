package br.com.alexandremarcondes.covid19.data.arcgis

import com.google.gson.annotations.SerializedName

data class Attributes (
    @SerializedName("OBJECTID") val OBJECTID : Int,
    @SerializedName("Province_State") val province_State : String,
    @SerializedName("Country_Region") val country_Region : String,
    @SerializedName("Last_Update") val last_Update : Long,
    @SerializedName("Lat") val lat : Double,
    @SerializedName("Long_") val long_ : Double,
    @SerializedName("Confirmed") val confirmed : Int,
    @SerializedName("Recovered") val recovered : Int,
    @SerializedName("Deaths") val deaths : Int,
    @SerializedName("Active") val active : Int,
    @SerializedName("Admin2") val admin2 : String,
    @SerializedName("FIPS") val FIPS : String,
    @SerializedName("Combined_Key") val combined_Key : String,
    @SerializedName("Report_Date") val report_Date : Long,
    @SerializedName("Mainland_China") val mainland_China : Int,
    @SerializedName("Other_Locations") val other_Locations : Int,
    @SerializedName("Total_Confirmed") val total_Confirmed : Int,
    @SerializedName("Total_Recovered") val total_Recovered : Int,
    @SerializedName("Report_Date_String") val report_Date_String : String,
    @SerializedName("Delta_Confirmed") val delta_Confirmed : Int,
    @SerializedName("Delta_Recovered") val delta_Recovered : Int,
    @SerializedName("ObjectId") val objectId : Int
)