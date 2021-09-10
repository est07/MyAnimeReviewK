package com.puzzlebench.myanimereviewk.domain.models

data class AnimeDetail(
    val title: String,
    val imageUrl: String,
    val synopsis: String,
    val type: String,
    val episodes: Int,
    val status: String,
    val score: Double,
    val rating: String,
    val rank: Int,
    val trailerUrl: String
)