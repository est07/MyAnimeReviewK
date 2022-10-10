package com.puzzlebench.myanimereviewk.data.apis

import com.puzzlebench.myanimereviewk.data.responses.AnimeDetailResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeSearchListResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeTopListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanApi {

    @GET("v4/top/anime")
    suspend fun getAnimeTopList(
        @Query("type") type: String = "tv",
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): AnimeTopListResponse

    @GET("v4/anime/{id}")
    suspend fun getAnimeDetail(
            @Path("id") id: Long
    ): AnimeDetailResponse

    @GET("v4/anime")
    suspend fun getAnimeSearchList(
        @Query("q") search: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 4
    ): AnimeSearchListResponse
}
