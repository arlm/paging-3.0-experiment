package br.com.alexandremarcondes.covid19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import br.com.alexandremarcondes.covid19.data.ArcgisHistoricalPagingSource
import br.com.alexandremarcondes.covid19.data.ArcgisPagingSource
import br.com.alexandremarcondes.covid19.data.CovidData
import br.com.alexandremarcondes.covid19.data.CovidHistoricalData
import br.com.alexandremarcondes.covid19.model.CovidPagingDataAdapter
import br.com.alexandremarcondes.covid19.model.CovidPagingHistoricalDataAdapter
import kotlinx.coroutines.flow.Flow

class CovidHistoricalViewModel : ViewModel() {
    private val pageSize: Int = 250

    // Kotlin Flow
    val pagingDataFlow: Flow<PagingData<CovidHistoricalData>> = PagingDataFlow(
        PagingConfig(pageSize)
    ) { ArcgisHistoricalPagingSource() }
        .cachedIn(viewModelScope)

    // LiveData
    val livePagingData : LiveData<PagingData<CovidHistoricalData>> = LivePagingData(
        PagingConfig(pageSize)
    ) { ArcgisHistoricalPagingSource() }
        .cachedIn(viewModelScope)

    val pagingAdapter = CovidPagingHistoricalDataAdapter()
}