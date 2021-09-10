package com.puzzlebench.myanimereviewk.data.apis

import com.puzzlebench.myanimereviewk.data.responses.AnimeDetailResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeSearchListResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeTopListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanApi {

    @GET("v3/top/anime/{page}")
    suspend fun getAnimeTopList(
        @Path("page") page: Int = 1
    ): AnimeTopListResponse

    @GET("v3/anime/{id}")
    suspend fun getAnimeDetail(
            @Path("id") id: Long
    ): AnimeDetailResponse

    @GET("v3/search/anime")
    suspend fun getAnimeSearchList(
        @Query("q") search: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 4
    ): AnimeSearchListResponse
}
