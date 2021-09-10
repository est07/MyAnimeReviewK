package com.puzzlebench.myanimereviewk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.databinding.FragmentAnimeListBinding
import com.puzzlebench.myanimereviewk.presentation.states.AnimeListState
import com.puzzlebench.myanimereviewk.presentation.viewModels.AnimeListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimeListFragment : Fragment(R.layout.fragment_anime_list) {

    private val animeListViewModel: AnimeListViewModel by viewModel()

    private var binding: FragmentAnimeListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeListBinding.bind(view)

        initObservers()
        animeListViewModel.getAnimeTopList()
    }

    private fun initObservers() {
        animeListViewModel.getAnimeListStateLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is AnimeListState.Loading -> {
                    //load
                }
                is AnimeListState.Success -> {
                    //data
                }
                else -> {
                    //error
                }
            }
        })
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
