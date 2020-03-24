package br.com.alexandremarcondes.covid19.ui.home

import android.view.View

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import br.com.alexandremarcondes.covid19.R
import br.com.alexandremarcondes.covid19.data.CovidData
import br.com.alexandremarcondes.covid19.data.CovidHistoricalData

class CovidHistoricalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val simpleTextView: TextView

    init {
        simpleTextView = itemView.findViewById(R.id.simple_text)
    }

    fun bindData(viewModel: CovidHistoricalData?) {
        if (viewModel != null) {
            simpleTextView.setText("${viewModel}:${viewModel.total_confirmed}/${viewModel.delta_recovered}/${viewModel.date}")
        } else {
            simpleTextView.setText("NO DATA")
        }
    }
}