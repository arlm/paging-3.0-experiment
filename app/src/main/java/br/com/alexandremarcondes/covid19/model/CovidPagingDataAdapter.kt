package br.com.alexandremarcondes.covid19.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import br.com.alexandremarcondes.covid19.data.CovidData
import br.com.alexandremarcondes.covid19.ui.home.CovidViewHolder

class CovidPagingDataAdapter : PagingDataAdapter<CovidData, CovidViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return CovidViewHolder(view)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val repoItem = getItem(position)
        // Note that item may be null if placeholders aren't disabled,
        // so our ViewHolder supports binding to null
        holder.bindData(repoItem)
    }

    companion object {
        val USER_COMPARATOR = object : DiffUtil.ItemCallback<CovidData>() {
            override fun areItemsTheSame(oldItem: CovidData, newItem: CovidData) =
                // User ID serves as unique ID
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CovidData, newItem: CovidData) =
            // Compare full contents
                // (note: Java users should call .equals()!)
                oldItem == newItem
        }
    }
}
