package com.puzzlebench.myanimereviewk.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myitemssearchk.presentation.extension.inflate
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.domain.models.AnimeSearch
import com.puzzlebench.myanimereviewk.presentation.adapters.ViewHolders.RelatedAnimeViewHolder
import kotlin.properties.Delegates

class RelatedAnimeAdapter(
        data: List<AnimeSearch> = emptyList()
) : RecyclerView.Adapter<RelatedAnimeViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedAnimeViewHolder =
            RelatedAnimeViewHolder(parent.inflate(R.layout.related_anime_item))

    override fun onBindViewHolder(holder: RelatedAnimeViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}
