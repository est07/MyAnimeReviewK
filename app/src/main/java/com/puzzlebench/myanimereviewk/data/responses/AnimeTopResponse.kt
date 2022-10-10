package com.puzzlebench.myanimereviewk.data.responses

import com.squareup.moshi.Json

data class AnimeTopResponse(
    @Json(name = "mal_id")
    val id: Long,
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "images")
    val images: AnimeTopImageJPGResponse,
    @Json(name = "type")
    val type: String,
    @Json(name = "episodes")
    val episodes: Int,
    @Json(name = "score")
    val score: Double,
    @Json(name = "aired")
    val aired: AnimeTopAired
)

data class AnimeTopImageJPGResponse(
    @Json(name = "jpg")
    val imageJPG: AnimeTopImageResponse,
)

data class AnimeTopImageResponse(
    @Json(name = "image_url")
    val imageUrl: String,
)

data class AnimeTopAired(
    @Json(name = "from")
    val startDate: String,
    @Json(name = "to")
    val endDate: String
)
