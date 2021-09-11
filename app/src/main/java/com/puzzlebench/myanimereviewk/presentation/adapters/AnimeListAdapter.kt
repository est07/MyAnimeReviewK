package com.puzzlebench.myanimereviewk.presentation.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myitemssearchk.presentation.extension.inflate
import com.example.myitemssearchk.presentation.listener.AnimeListListener
import com.puzzlebench.myanimereviewk.R
import com.puzzlebench.myanimereviewk.domain.models.AnimeTop
import com.puzzlebench.myanimereviewk.presentation.adapters.ViewHolders.AnimeListViewHolder
import kotlin.properties.Delegates

class AnimeListAdapter(
        data: List<AnimeTop> = emptyList(),
        private val listener: AnimeListListener
) : RecyclerView.Adapter<AnimeListViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeListViewHolder =
        AnimeListViewHolder(parent.inflate(R.layout.anime_item), listener)

    override fun onBindViewHolder(holder: AnimeListViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}
