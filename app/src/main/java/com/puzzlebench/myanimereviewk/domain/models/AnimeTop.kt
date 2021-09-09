package com.puzzlebench.myanimereviewk.domain.models

data class AnimeTop(
    val rank: Int,
    val title: String,
    val imageUrl: String,
    val type: String,
    val episodes: Int,
    val score: Double,
    val startDate: String,
    val endDate: String
)
