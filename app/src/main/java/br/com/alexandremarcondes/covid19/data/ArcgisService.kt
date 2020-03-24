package br.com.alexandremarcondes.covid19.data

import android.util.Log
import br.com.alexandremarcondes.covid19.data.arcgis.ArcgisData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArcgisService {
    private val service: ArcgisServiceApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://services9.arcgis.com/N9p5hsImWXAccRNI/arcgis/rest/services/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ArcgisServiceApi::class.java)
    }

    suspend fun getData(
        region: String,
        offset: Int,
        recordCount: Int
    ): ArcgisData? {
        val where = "(Confirmed > 0) AND (Country_Region='$region')"
        val call = service.getData(where = where,
            resultOffset =  offset, resultRecordCount =  recordCount)

        return getArcgisData(call)
    }

    suspend fun getData(
        offset: Int,
        recordCount: Int
    ): ArcgisData? {
        val call = service.getData(resultOffset =  offset, resultRecordCount =  recordCount)

        return getArcgisData(call)
    }

    private suspend  fun getArcgisData(call: Call<ArcgisData>): ArcgisData? {
        var data : ArcgisData? = null

        withContext(Dispatchers.IO) {
            val response = call.execute()

            if (response.isSuccessful){
                data = response.body()

                if (data!!.error == null) {
                    Log.d(
                        "retrofit", "message: ${response.message()}\n" +
                                "isSuccessful: ${response.isSuccessful}\n" +
                                "code: ${response.code()}\n" +
                                "errorBody: ${response.errorBody()}\n" +
                                "body: ${response.body()}\n" +
                                "url: ${call.request().url()}\n" +
                                "request headers:\n${call.request().headers()}\n"
                    )
                } else {
                    Log.e(
                        "retrofit", "message: ${response.message()}\n" +
                                "isSuccessful: ${response.isSuccessful}\n" +
                                "code: ${response.code()}\n" +
                                "errorBody: ${response.errorBody()}\n" +
                                "body: ${response.body()}\n" +
                                "url: ${call.request().url()}\n" +
                                "request headers:\n${call.request().headers()}\n"+
                                "${data!!.error}\n"
                    )
                }
            } else {
                Log.e(
                    "retrofit",
                    "${call.request().url()}: ${response.errorBody()}"
                )
            }
        }

        return data
    }

}