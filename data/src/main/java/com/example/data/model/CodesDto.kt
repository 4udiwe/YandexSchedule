package com.example.data.model

import com.example.domain.model.Codes
import com.google.gson.annotations.SerializedName


data class CodesDto (

  @SerializedName("sirena" ) var sirena : String? = null,
  @SerializedName("iata"   ) var iata   : String? = null,
  @SerializedName("icao"   ) var icao   : String? = null

) {
    fun toDomain() : Codes = Codes(sirena, iata, icao)
}