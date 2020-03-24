package br.com.alexandremarcondes.covid19.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alexandremarcondes.covid19.R
import br.com.alexandremarcondes.covid19.data.CovidData
import br.com.alexandremarcondes.covid19.model.CovidPagingDataAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var viewModel: CovidViewModel
    private lateinit var pagingAdapter: CovidPagingDataAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val recyclerView: RecyclerView = root.findViewById(R.id.recicler_view)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        pagingAdapter = CovidPagingDataAdapter()
        recyclerView.adapter = pagingAdapter

        viewModel = ViewModelProviders.of(this).get(CovidViewModel::class.java)

        // Kotlin Flow
        lifecycleScope.launch {
            viewModel.pagingDataFlow
                .collectLatest { pagingData ->
                    pagingAdapter.presentData(pagingData)
                }
        }

        // LiveData
        /*
        viewModel.pagingLiveData.observe(viewLifecycleOwner) { pagingData ->
            pagingAdapter.submitData(lifecycle, pagingData)
        }
        */

        return root
    }
}
