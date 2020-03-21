package br.com.alexandremarcondes.covid19.data

data class Attributes (
    val oBJECTID : Int,
    val province_State : String,
    val country_Region : String,
    val last_Update : Int,
    val lat : Double,
    val long_ : Double,
    val confirmed : Int,
    val recovered : Int,
    val deaths : Int,
    val active : Int,
    val admin2 : String,
    val fIPS : String,
    val combined_Key : String
)