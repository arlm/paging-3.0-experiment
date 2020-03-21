package br.com.alexandremarcondes.covid19.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import br.com.alexandremarcondes.covid19.data.ArcgisPagingSource
import br.com.alexandremarcondes.covid19.data.CovidData

class CovidViewModel : ViewModel() {
    val livePagingData : LiveData<PagingData<CovidData>> = LivePagingData(
        PagingConfig(50)
    ) { ArcgisPagingSource() }
        .cachedIn(viewModelScope)

    fun getData(): LiveData<PagingData<CovidData>> {
        return livePagingData
    }

    private fun loadData() {
        // Do an asynchronous operation to fetch users.
    }
}