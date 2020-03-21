package br.com.alexandremarcondes.covid19.data

import android.os.Build
import androidx.paging.PagingSource
import retrofit2.HttpException
import java.io.IOException
import java.time.Instant
import java.util.*

class ArcgisPagingSource(
        private val myBackend: ArcgisService = ArcgisService()
    ) : PagingSource<String, CovidData>() {
    override suspend fun load(params: LoadParams<String>) =
        try {
            // suspending network load, executes automatically on worker thread
            val response = myBackend.getData(0, 250)
            val covidDatum = mutableListOf<CovidData>()

            response?.features?.forEach{
                val date = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Date(Instant.ofEpochSecond(it.attributes.last_Update.toLong()).toEpochMilli())
                } else {
                    Date(it.attributes.last_Update.toLong() * 1000)
                }

                val data = CovidData(
                    id = it.attributes.oBJECTID,
                    cases = it.attributes.confirmed,
                    deaths = it.attributes.deaths,
                    recoveries = it.attributes.recovered,
                    activeCases = it.attributes.active,
                    country = it.attributes.country_Region,
                    county = null,
                    region = it.attributes.province_State,
                    date = date
                )

                covidDatum.add(data)
            }

            LoadResult.Page(
                data = covidDatum,
                prevKey = covidDatum.firstOrNull()?.country ?: "",
                nextKey = covidDatum.lastOrNull()?.country ?: ""
            )
        } catch (e: IOException) {
            LoadResult.Error<String, CovidData>(e)
        } catch (e: HttpException) {
            LoadResult.Error<String, CovidData>(e)
    }
}
