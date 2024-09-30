package com.example.data.model

import com.example.domain.model.TransportSubtype
import com.google.gson.annotations.SerializedName


data class TransportSubtypeDto(

    @SerializedName("color") var color: String? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("title") var title: String? = null

) {
    fun toDomain(): TransportSubtype = TransportSubtype(color, code, title)
}