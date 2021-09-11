package com.puzzlebench.myanimereviewk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myitemssearchk.presentation.extension.gone
import com.example.myitemssearchk.presentation.extension.visible
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.databinding.FragmentAnimeListBinding
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import com.puzzlebench.myanimereviewk.presentation.adapters.AnimeListAdapter
import com.puzzlebench.myanimereviewk.presentation.states.AnimeListState
import com.puzzlebench.myanimereviewk.presentation.viewModels.AnimeListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimeListFragment : Fragment(R.layout.fragment_anime_list) {

    private val animeListViewModel: AnimeListViewModel by viewModel()

    private val adapter = AnimeListAdapter(listOf()) { itemSearch ->
        gotoAnimeFragment(R.id.action_animeListFragment_to_animeDetailFragment)
    }

    private var binding: FragmentAnimeListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeListBinding.bind(view)

        initObservers()
        initListeners()
        initView()
    }
    private fun initListeners() {
        binding?.btnRetry?.setOnClickListener {
            getAnimeList()
        }
    }

    private fun initObservers() {
        animeListViewModel.getAnimeListStateLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is AnimeListState.Loading -> {
                    showProgress()
                }
                is AnimeListState.Success -> {
                    validateAnimeList(state.item)
                }
                else -> {
                    showNetworkError()
                }
            }
        })
    }

    private fun getAnimeList() {
        animeListViewModel.getAnimeTopList()
    }

    private fun initView() {
        binding?.apply {
            rvAnimeList.layoutManager = LinearLayoutManager(context)
            rvAnimeList.adapter = adapter
        }
        getAnimeList()
    }

    private fun validateAnimeList(items: List<AnimeTop>) {
        if (!items.isNullOrEmpty()) {
            showAnimeList(items)
        } else {
            showServiceError()
        }
    }

    private fun showAnimeList(items: List<AnimeTop>) {
        adapter.data = items
        hideProgress()
        binding?.rvAnimeList?.visible()
    }

    private fun showProgress() {
        binding?.apply {
            pbAnimeList.visible()
            txvNoDataFound.gone()
            ivServiceFailed.gone()
            rvAnimeList.gone()
            btnRetry.gone()
        }
    }

    private fun hideProgress() {
        binding?.pbAnimeList?.gone()
    }

    private fun showNetworkError() {
        hideProgress()
        showErrorFields()
        showNetworkErrorFiled()
    }

    private fun showServiceError() {
        hideProgress()
        showErrorFields()
        showNoFoundList()
    }

    private fun showErrorFields() {
        binding?.apply {
            txvNoDataFound.visible()
            ivServiceFailed.visible()
            btnRetry.visible()
        }
    }

    private fun showNetworkErrorFiled() {
        binding?.apply {
            ivServiceFailed.setBackgroundResource(R.drawable.ic_wifi_off_120)
            txvNoDataFound.text = getString(R.string.anime_list_fragment_network_error)

        }
    }

    private fun showNoFoundList(){
        binding?.apply {
            ivServiceFailed.setBackgroundResource(R.drawable.ic_search_failed_100)
            txvNoDataFound.text = getString(R.string.anime_list_fragment_no_data_found)
        }
    }

    private fun gotoAnimeFragment(navigationAction: Int) {
        view?.findNavController()?.navigate(navigationAction)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
