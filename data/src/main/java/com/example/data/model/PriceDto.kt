package com.example.data.model

import com.example.domain.model.Price
import com.google.gson.annotations.SerializedName


data class PriceDto(

    @SerializedName("cents") var cents: Int? = null,
    @SerializedName("whole") var whole: Int? = null

) {
    fun toDomain(): Price = Price(cents, whole)
}