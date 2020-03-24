package br.com.alexandremarcondes.covid19.ui.home

import android.view.View

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import br.com.alexandremarcondes.covid19.R
import br.com.alexandremarcondes.covid19.data.CovidData

class CovidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val simpleTextView: TextView

    init {
        simpleTextView = itemView.findViewById(R.id.simple_text)
    }

    fun bindData(viewModel: CovidData?) {
        if (viewModel != null) {
            simpleTextView.setText("${viewModel.country}:${viewModel.cases}/${viewModel.deaths}/${viewModel.recoveries}")
        } else {
            simpleTextView.setText("NO DATA")
        }
    }
}