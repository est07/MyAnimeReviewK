package com.puzzlebench.myanimereviewk.presentation.adapters.ViewHolders

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myitemssearchk.presentation.extension.getImageByUrl
import com.puzzlebench.myanimereviewk.databinding.RelatedAnimeItemBinding
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch

class RelatedAnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = RelatedAnimeItemBinding.bind(view)
    fun bind(item: AnimeSearch) = with(binding) {
        imvAnime.getImageByUrl(item.imageUrl)
        imvAnime.setBackgroundColor(Color.TRANSPARENT)
        txvAnimeTitle.text = item.title
    }
}
