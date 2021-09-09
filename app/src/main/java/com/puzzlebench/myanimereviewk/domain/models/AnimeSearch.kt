package com.puzzlebench.myanimereviewk.domain.models

data class AnimeSearch(
    val title: String,
    val imageUrl: String,
    val synopsis: String,
    val type: String,
    val episodes: Int,
    val score: Double,
    val rated: String
)
