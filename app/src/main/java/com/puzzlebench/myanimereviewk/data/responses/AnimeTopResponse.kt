package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeTopResponse(
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "episodes")
    val episodes: Int,
    @Json(name = "score")
    val score: Double,
    @Json(name = "start_date")
    val startDate: String,
    @Json(name = "end_date")
    val endDate: String
)
