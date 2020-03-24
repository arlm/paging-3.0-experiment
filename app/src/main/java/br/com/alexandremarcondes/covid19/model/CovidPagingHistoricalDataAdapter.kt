package br.com.alexandremarcondes.covid19.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import br.com.alexandremarcondes.covid19.R
import br.com.alexandremarcondes.covid19.data.CovidData
import br.com.alexandremarcondes.covid19.data.CovidHistoricalData
import br.com.alexandremarcondes.covid19.ui.home.CovidHistoricalViewHolder
import br.com.alexandremarcondes.covid19.ui.home.CovidViewHolder

class CovidPagingHistoricalDataAdapter : PagingDataAdapter<CovidHistoricalData, CovidHistoricalViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidHistoricalViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.covid_item_view, parent, false)
        return CovidHistoricalViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidHistoricalViewHolder, position: Int) {
        val repoItem = getItem(position)
        // Note that item may be null if placeholders aren't disabled,
        // so our ViewHolder supports binding to null
        holder.bindData(repoItem)
    }

    companion object {
        val USER_COMPARATOR = object : DiffUtil.ItemCallback<CovidHistoricalData>() {
            override fun areItemsTheSame(oldItem: CovidHistoricalData, newItem: CovidHistoricalData) =
                // User ID serves as unique ID
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CovidHistoricalData, newItem: CovidHistoricalData) =
            // Compare full contents
                // (note: Java users should call .equals()!)
                oldItem == newItem
        }
    }
}
