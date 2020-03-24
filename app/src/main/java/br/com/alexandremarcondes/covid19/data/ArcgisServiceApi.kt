package br.com.alexandremarcondes.covid19.data

import br.com.alexandremarcondes.covid19.data.arcgis.ArcgisData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ArcgisServiceApi {
    @Headers(
        "origin: https://www.arcgis.com",
        "referer: https://www.arcgis.com/apps/opsdashboard/index.html",
        "Accept: application/json",
        "Content-type:application/json"
    )
    @GET("Z7biAeD8PAkqgmWhxG2A/FeatureServer/1/query")
    fun getData(@Query("where") where: String = "1=1",
                @Query("resultOffset") resultOffset: Int = 0,
                @Query("resultRecordCount") resultRecordCount: Int = 250,
                @Query("f") f: String = "json",
                @Query("returnGeometry")returnGeometry: Boolean = false,
                @Query("spatialRel") spatialRel: String = "esriSpatialRelIntersects",
                @Query("orderByFields") orderByFields:String ="Deaths desc,Confirmed desc,Country_Region asc,Province_State asc",
                @Query("outFields") outFields:String ="*",
                @Query("outSR") outSR:Int = 102100,
                @Query("cacheHint")cacheHint:Boolean = true): Call<ArcgisData>
}