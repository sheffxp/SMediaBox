package ru.lnv.smediabox.domain.models.request

import com.squareup.moshi.Json

data class RequestSession (
    @field:Json(name ="session_id") val sessionId: String
)