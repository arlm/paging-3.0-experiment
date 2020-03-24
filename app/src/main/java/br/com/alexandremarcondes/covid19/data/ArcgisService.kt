package br.com.alexandremarcondes.covid19.data

import android.util.Log
import br.com.alexandremarcondes.covid19.data.arcgis.ArcgisData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArcgisService {
    val service: ArcgisServiceApi

    constructor() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://services9.arcgis.com/N9p5hsImWXAccRNI/arcgis/rest/services/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ArcgisServiceApi::class.java)
    }

    fun getData(
        region: String,
        offset: Int,
        recordCount: Int
    ): ArcgisData? {
        var where = "(Confirmed > 0) AND (Country_Region='$region')"
        var call = service.getData(where = where,
            resultOffset =  offset, resultRecordCount =  recordCount)
        var data: ArcgisData? = null

        call.enqueue(object : Callback<ArcgisData> {
            override fun onResponse(call: Call<ArcgisData>, response: Response<ArcgisData>) {
                data = response.body()!!
            }

            override fun onFailure(call: Call<ArcgisData>, t: Throwable) {
                Log.e("retrofit", call.request().url().toString(), t)
            }
        })

        return data
    }

    fun getData(
        offset: Int,
        recordCount: Int
    ): ArcgisData? {
        var call = service.getData(resultOffset =  offset, resultRecordCount =  recordCount)
        var data: ArcgisData? = null

        call.enqueue(object : Callback<ArcgisData> {
            override fun onResponse(call: Call<ArcgisData>, response: Response<ArcgisData>) {
                data = response.body()!!
            }

            override fun onFailure(call: Call<ArcgisData>, t: Throwable) {
                Log.e("retrofit", call.request().url().toString(), t)
            }
        })

        return data
    }

}