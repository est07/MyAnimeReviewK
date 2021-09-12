package com.puzzlebench.myanimereviewk.presentation.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myitemssearchk.presentation.extension.getImageByUrl
import com.example.myitemssearchk.presentation.extension.gone
import com.example.myitemssearchk.presentation.extension.visible
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.databinding.FragmentAnimeDetailBinding
import com.puzzlebench.myanimereviewk.domain.models.AnimeDetail
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.presentation.adapters.RelatedAnimeAdapter
import com.puzzlebench.myanimereviewk.presentation.states.AnimeDetailState
import com.puzzlebench.myanimereviewk.presentation.states.AnimeSearchState
import com.puzzlebench.myanimereviewk.presentation.viewModels.AnimeDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimeDetailFragment : Fragment(R.layout.fragment_anime_detail) {

    private val animeDetailViewModel: AnimeDetailViewModel by viewModel()

    private val adapter = RelatedAnimeAdapter(listOf())

    private val animeId: Long
        get() = arguments?.getLong(ANIME_ID) ?: 0L

    private val animeTitle: String
        get() = arguments?.getString(ANIME_TITLE) ?: String()

    private var binding: FragmentAnimeDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimeDetailBinding.bind(view)

        initListeners()
        initObservers()
        initView()
        getAnimeDetail()
        showProgress()
    }

    private fun initListeners() {
        binding?.apply {
            tbAnimeDetail.setNavigationOnClickListener {
                backPressed()
            }
            btnRetry.setOnClickListener {
                getAnimeDetail()
            }
        }
    }

    private fun initObservers() {
        animeDetailViewModel.getAnimeDetailStateLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is AnimeDetailState.Loading -> {
                    showProgress()
                }
                is AnimeDetailState.Success -> {
                    hideProgress()
                    showAnimeDetail(state.item)
                    getRelatedAnimes()
                }
                else -> {
                    showNetworkError()
                }
            }
        })

        animeDetailViewModel.getAnimeSearchStateStateLiveData.observe(viewLifecycleOwner, { state ->
            when (state) {
                is AnimeSearchState.Loading -> {
                    hideProgress()
                }
                is AnimeSearchState.Success -> {
                    showRelatedAnimeList(state.item)
                }
                else -> {
                    hideRelatedAnimeList()
                }
            }
        })
    }

    private fun initView() {
        binding?.apply {
            rvRelatedAnimeList.layoutManager =
                    LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            rvRelatedAnimeList.adapter = adapter
        }
    }

    private fun getAnimeDetail() {
        if (animeId != 0L) {
            animeDetailViewModel.getAnimeDetail(animeId)
        }
    }

    private fun showAnimeDetail(animeDetail: AnimeDetail) {
        hideErrorField()
        binding?.apply {
            cvAnimeDetail.visible()
            cvAnimeSynopsis.visible()
            txvAnimeSynopsisTitle.visible()
            with(animeDetail){

                imvAnimeDetail.getImageByUrl(imageUrl)
                imvAnimeDetail.setBackgroundColor(Color.TRANSPARENT)
                txvAnimeTitle.text = title
                txvAnimeType.text =
                        getString(R.string.anime_detail_fragment_detail_anime_type, type)
                txvAnimeStatus.text =
                        getString(R.string.anime_detail_fragment_detail_anime_state, status)
                txvAnimeRank.text =
                        getString(R.string.anime_detail_fragment_detail_anime_rank, rank)
                txvAnimeScore.text =
                        getString(R.string.anime_detail_fragment_detail_anime_score, score)
                txvAnimeEpisodes.text =
                        getString(R.string.anime_detail_fragment_detail_anime_episodes, episodes)
                txvAnimeRating.text = rating
                txvAnimeSynopsis.text = synopsis
                validateTrailer(trailerUrl)
            }
        }
    }

    private fun validateTrailer(trailerUrl: String) {
        binding?.apply {
            if (trailerUrl.isNotEmpty()){
                txvAnimeTrailerTitle.visible()
                cvAnimeTrailerUrl.visible()
                initTrailerListener(trailerUrl)
                txvAnimeTrailerUrl.text = HtmlCompat.fromHtml(
                        getString(
                                R.string.anime_detail_fragment_detail_anime_trailer_link,
                                trailerUrl
                        ),
                        HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }else{
                txvAnimeTrailerTitle.gone()
                cvAnimeTrailerUrl.gone()
            }
        }
    }

    private fun initTrailerListener(trailerUrl: String){
        binding?.txvAnimeTrailerUrl?.setOnClickListener {
            startActivity(
                    Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(trailerUrl)
                    )
            )
        }
    }

    private fun getRelatedAnimes() {
        if (animeTitle.isNotEmpty()) {
            animeDetailViewModel.getAnimeSearchList(animeTitle)
        }
    }

    private fun showRelatedAnimeList(items: List<AnimeSearch>) {
        binding?.apply {
            if (items.isNotEmpty()) {
                adapter.data = items
                txvRelatedAnimesTitle.visible()
                cvRelatedAnimes.visible()
            } else {
                txvRelatedAnimesTitle.gone()
                cvRelatedAnimes.gone()
            }
        }
    }

    private fun showProgress() {
        hideErrorField()
        binding?.apply {
            pbAnimeDetail.visible()
            cvDetailLoading.visible()
            cvAnimeDetail.gone()
            txvAnimeSynopsisTitle.gone()
            cvAnimeSynopsis.gone()
            hideRelatedAnimeList()
        }
    }

    private fun showNetworkError() {
        binding?.apply {
            pbAnimeDetail.gone()
            txvNoDataFound.visible()
            ivServiceFailed.visible()
            btnRetry.visible()
            ivServiceFailed.setBackgroundResource(R.drawable.ic_wifi_off_120)
            txvNoDataFound.text = getString(R.string.anime_list_fragment_network_error)
        }
    }

    private fun hideRelatedAnimeList(){
        binding?.apply {
            txvRelatedAnimesTitle.gone()
            cvRelatedAnimes.gone()
        }
    }

    private fun hideProgress() {
        binding?.apply {
            cvDetailLoading.gone()
            pbAnimeDetail.gone()
        }
    }

    private fun hideErrorField(){
        binding?.apply {
            txvNoDataFound.gone()
            ivServiceFailed.gone()
            btnRetry.gone()
        }
    }

    private fun backPressed() {
        activity?.onBackPressed()
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    companion object {
        const val ANIME_ID = "animeId"
        const val ANIME_TITLE = "animeTitle"
    }
}
