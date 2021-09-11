package com.puzzlebench.myanimereviewk.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.databinding.FragmentAnimeDetailBinding

class AnimeDetailFragment : Fragment(R.layout.fragment_anime_detail) {

    private var binding: FragmentAnimeDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeDetailBinding.bind(view)

        initListeners()
    }

    private fun initListeners() {
        binding?.tbAnimeDetail?.setNavigationOnClickListener {
            backPressed()
        }
    }

    private fun backPressed() {
        activity?.onBackPressed()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}
