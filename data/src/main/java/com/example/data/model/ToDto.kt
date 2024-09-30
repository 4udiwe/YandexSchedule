package com.example.data.model

import com.example.domain.model.To
import com.google.gson.annotations.SerializedName


data class ToDto(

    @SerializedName("code") var code: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("popular_title") var popularTitle: String? = null,
    @SerializedName("short_title") var shortTitle: String? = null,
    @SerializedName("title") var title: String? = null

) {
    fun toDomain(): To = To(code, type, popularTitle, shortTitle, title)
}