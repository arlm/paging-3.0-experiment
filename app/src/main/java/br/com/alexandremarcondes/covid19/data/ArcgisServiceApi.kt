package br.com.alexandremarcondes.covid19.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ArcgisServiceApi {
    @GET("Z7biAeD8PAkqgmWhxG2A/FeatureServer/1/query?f=json&where={where}&returnGeometry=false&spatialRel=esriSpatialRelIntersects&outFields=*&orderByFields=Deaths%20desc%2CCountry_Region%20asc%2CProvince_State%20asc&outSR=102100&resultOffset={offset}}&resultRecordCount={recordCount}&cacheHint=true")
    fun getData(@Path("where") where: String, @Path("offset") offset: Int, @Path("recordCount") recordCount: Int): Call<ArcgisData>
}