package com.example.data.model

import com.example.domain.model.Codes
import com.google.gson.annotations.SerializedName


data class CodesDto(

    @SerializedName("icao") var icao: String? = null,
    @SerializedName("sirena") var sirena: String? = null,
    @SerializedName("iata") var iata: String? = null

) {
    fun toDomain() : Codes{
        return Codes(icao, sirena, iata)
    }
}