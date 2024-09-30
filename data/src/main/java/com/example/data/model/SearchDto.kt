package com.example.data.model


import com.example.domain.model.Search
import com.google.gson.annotations.SerializedName


data class SearchDto (

    @SerializedName("from" ) var from : FromDto? = FromDto(),
    @SerializedName("to"   ) var to   : ToDto?   = ToDto(),
    @SerializedName("date" ) var date : String?  = null

){
    fun toDomain(): Search = Search(from?.toDomain(), to?.toDomain(), date)
}