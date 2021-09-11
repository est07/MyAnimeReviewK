package com.puzzlebench.myanimereviewk.presentation.adapters.ViewHolders

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myitemssearchk.presentation.extension.getImageByUrl
import com.example.myitemssearchk.presentation.listener.AnimeListListener
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.databinding.AnimeItemBinding
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop

class AnimeListViewHolder(
    view: View,
    val listener: AnimeListListener
) : RecyclerView.ViewHolder(view) {

    private val binding = AnimeItemBinding.bind(view)
    fun bind(item: AnimeTop) = with(binding) {
        imvAnime.getImageByUrl(item.imageUrl)
        imvAnime.setBackgroundColor(Color.TRANSPARENT)
        txvAnimeTitle.text = item.title
        txvAnimeType.text =
            root.context.getString(R.string.item_list_fragment_detail_anime_type, item.type)
        txvAnimeState.text =
            root.context.getString(
                R.string.item_list_fragment_detail_anime_state,
                if (item.endDate.isEmpty())
                    root.context.getString(R.string.item_list_fragment_detail_anime_on_airing)
                else
                    root.context.getString(R.string.item_list_fragment_detail_anime_finished)
            )
        txvAnimeRank.text =
            root.context.getString(R.string.item_list_fragment_detail_anime_rank, item.rank)
        txvAnimeScore.text =
            root.context.getString(R.string.item_list_fragment_detail_anime_score, item.score)
        txvAnimeEpisodes.text =
            root.context.getString(R.string.item_list_fragment_detail_anime_episodes, item.episodes)
        root.setOnClickListener { listener(item) }
    }
}
