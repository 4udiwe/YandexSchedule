package com.example.data.model

import com.example.domain.model.Places
import com.google.gson.annotations.SerializedName


data class PlacesDto(

    @SerializedName("currency") var currency: String? = null,
    @SerializedName("price") var price: PriceDto? = PriceDto(),
    @SerializedName("name") var name: String? = null

) {
    fun toDomain(): Places = Places(currency, price?.toDomain(), name)
}