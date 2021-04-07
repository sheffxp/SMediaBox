package ru.lnv.smediabox.data.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface YouTubeApi {
    @GET("search/")
    fun searchYouTubeVideos(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("maxResults") maxResults: Int,
        @Query("pageToken") pageToken: String?,
        @Query("order") order: String,
        @Query("channelId") channelId: String
    ): Call<GetYouTubeTrailerResponse>
}