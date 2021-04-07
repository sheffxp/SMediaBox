package ru.lnv.smediabox.models.genre

import com.google.gson.annotations.SerializedName


data class GenreResponse(
    @SerializedName("genres") val genres: List<Genre>
)
