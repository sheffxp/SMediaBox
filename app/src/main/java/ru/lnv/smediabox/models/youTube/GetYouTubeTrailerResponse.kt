package ru.lnv.smediabox.models.youTube

import com.google.gson.annotations.SerializedName

data class GetYouTubeTrailerResponse(
    @SerializedName("etag") val etag: String,
    @SerializedName("items") val items: List<Item>,
    @SerializedName("kind") val kind: String,
    @SerializedName("nextPageToken") val nextPageToken: String,
    @SerializedName("pageInfo")  val pageInfo: PageInfo,
    @SerializedName("prevPageToken")  val prevPageToken: String?,
    @SerializedName( "regionCode") val regionCode: String
) {
    data class Item(
        @SerializedName ("etag") val etag: String,
        @SerializedName( "id")  val id: Id,
        @field:Json(name = "kind")
        val kind: String,
        @field:Json(name = "snippet")
        val snippet: Snippet
    ) {
        data class Id(
            @field:Json(name = "kind")
            val kind: String,
            @field:Json(name = "videoId")
            val videoId: String
        )

        data class Snippet(
            @field:Json(name = "channelId")
            val channelId: String,
            @field:Json(name = "channelTitle")
            val channelTitle: String,
            @field:Json(name = "description")
            val description: String,
            @field:Json(name = "liveBroadcastContent")
            val liveBroadcastContent: String,
            @field:Json(name = "publishedAt")
            val publishedAt: String,
            @field:Json(name = "thumbnails")
            val thumbnails: Thumbnails,
            @field:Json(name = "title")
            val title: String
        ) {
            data class Thumbnails(
                @field:Json(name = "default")
                val default: Default,
                @field:Json(name = "high")
                val high: High,
                @field:Json(name = "medium")
                val medium: Medium
            ) {
                data class Default(
                    @field:Json(name = "height")
                    val height: Int,
                    @field:Json(name = "url")
                    val url: String,
                    @field:Json(name = "width")
                    val width: Int
                )

                data class High(
                    @field:Json(name = "height")
                    val height: Int,
                    @field:Json(name = "url")
                    val url: String,
                    @field:Json(name = "width")
                    val width: Int
                )

                data class Medium(
                    @field:Json(name = "height")
                    val height: Int,
                    @field:Json(name = "url")
                    val url: String,
                    @field:Json(name = "width")
                    val width: Int
                )
            }
        }
    }

    data class PageInfo(
        @field:Json(name = "resultsPerPage")
        val resultsPerPage: Int,
        @field:Json(name = "totalResults")
        val totalResults: Int
    )
}
