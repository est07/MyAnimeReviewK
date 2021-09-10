package com.puzzlebench.myanimereviewk.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.presentation.states.AnimeListState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val animeListViewModel: AnimeListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initObservers()
        animeListViewModel.getAnimeTopList()
    }

    private fun initObservers() {
        animeListViewModel.getAnimeListStateLiveData.observe(this, { state ->
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
}