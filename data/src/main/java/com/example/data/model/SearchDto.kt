package com.example.data.model


import com.example.domain.model.Search
import com.google.gson.annotations.SerializedName


data class SearchDto(

    @SerializedName("date") var date: String? = null,
    @SerializedName("to") var to: ToDto? = ToDto(),
    @SerializedName("from") var from: FromDto? = FromDto()

) {
    fun toDomain(): Search = Search(date, to?.toDomain(), from?.toDomain())
}