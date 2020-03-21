package br.com.alexandremarcondes.covid19.data

import retrofit2.Retrofit

class ArcgisService {
    val service: ArcgisServiceApi

    constructor() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://services9.arcgis.com/N9p5hsImWXAccRNI/arcgis/rest/services")
            //.addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ArcgisServiceApi::class.java)
    }

    fun getData(
        region: String,
        offset: Int,
        recordCount: Int
    ): ArcgisData? {
        var where = "(Confirmed > 0) AND (Country_Region='$region')"
        var call = service.getData(where, offset, recordCount)
        return call.execute().body()
    }

    fun getData(
        offset: Int,
        recordCount: Int
    ): ArcgisData? {
        var call = service.getData("1=1", offset, recordCount)
        return call.execute().body()
    }

}