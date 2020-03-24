package br.com.alexandremarcondes.covid19.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import br.com.alexandremarcondes.covid19.data.ArcgisPagingSource
import br.com.alexandremarcondes.covid19.data.CovidData
import br.com.alexandremarcondes.covid19.model.CovidPagingDataAdapter
import kotlinx.coroutines.flow.Flow

class CovidViewModel : ViewModel() {
    private val pageSize: Int = 250

    // Kotlin Flow
    val pagingDataFlow: Flow<PagingData<CovidData>> = PagingDataFlow(
        PagingConfig(pageSize)
    ) { ArcgisPagingSource() }
        .cachedIn(viewModelScope)

    // LiveData
    val livePagingData : LiveData<PagingData<CovidData>> = LivePagingData(
        PagingConfig(pageSize)
    ) { ArcgisPagingSource() }
        .cachedIn(viewModelScope)

    val pagingAdapter = CovidPagingDataAdapter()
}