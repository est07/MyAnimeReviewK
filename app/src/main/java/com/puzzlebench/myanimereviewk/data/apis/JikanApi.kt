package com.puzzlebench.myanimereviewk.data.apis

import com.puzzlebench.myanimereviewk.data.responses.AnimeSearchListResponse
import com.puzzlebench.myanimereviewk.data.responses.AnimeTopListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanApi {

    @GET("v3/top/anime/{page}")
    fun getAnimeTopList(
        @Path("page") page: Int = 1
    ): Single<AnimeTopListResponse>

    @GET("v3/search/anime")
    fun getAnimeSearchList(
        @Query("q") search: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 4
    ): Single<AnimeSearchListResponse>
}
