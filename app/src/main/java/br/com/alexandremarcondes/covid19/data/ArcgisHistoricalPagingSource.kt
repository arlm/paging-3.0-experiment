package br.com.alexandremarcondes.covid19.data

import android.os.Build
import android.util.Log
import androidx.paging.PagingSource
import retrofit2.HttpException
import java.io.IOException
import java.time.Instant
import java.util.*

class ArcgisHistoricalPagingSource(
        private val myBackend: ArcgisService = ArcgisService()
    ) : PagingSource<String, CovidHistoricalData>() {
    override suspend fun load(params: LoadParams<String>) =
        try {
            // suspending network load, executes automatically on worker thread
            val response = myBackend.getHistoricalData(0, 250)
            val covidDatum = mutableListOf<CovidHistoricalData>()

            response?.features?.forEach{
                val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Date(Instant.ofEpochSecond(it.attributes.report_Date).toEpochMilli())
                } else {
                    Date(it.attributes.report_Date * 1000)
                }

                val data = CovidHistoricalData(
                    id = it.attributes.objectId,
                    mainland_china_cases = it.attributes.mainland_China,
                    other_locations_cases = it.attributes.other_Locations,
                    delta_confirmed = it.attributes.delta_Confirmed,
                    delta_recovered = it.attributes.delta_Recovered,
                    total_confirmed = it.attributes.total_Confirmed,
                    total_recovered = it.attributes.total_Recovered,
                    date = date,
                    date_string = it.attributes.report_Date_String
                )

                Log.i(this.javaClass.simpleName, data.toString() )

                covidDatum.add(data)
            }

            LoadResult.Page(
                data = covidDatum,
                prevKey = covidDatum.firstOrNull()?.date_string ?: "",
                nextKey = covidDatum.lastOrNull()?.date_string ?: ""
            )
        } catch (e: IOException) {
            LoadResult.Error<String, CovidHistoricalData>(e)
        } catch (e: HttpException) {
            LoadResult.Error<String, CovidHistoricalData>(e)
    }
}
