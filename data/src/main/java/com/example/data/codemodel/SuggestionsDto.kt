package com.example.data.codemodel

import com.example.domain.codemodel.Suggestions
import com.google.gson.annotations.SerializedName


data class SuggestionsDto (

    @SerializedName("suggests"        ) var suggests      : ArrayList<SuggestsDto> = arrayListOf(),
    @SerializedName("total_found"     ) var totalFound    : Int?                   = null,
    @SerializedName("has_exact_match" ) var hasExactMatch : Boolean?               = null

){
    fun toDomain(): Suggestions =
        Suggestions(suggests.map { it.toDomain() } as ArrayList, totalFound, hasExactMatch)
}