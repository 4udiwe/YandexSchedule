package com.example.data.model

import com.example.domain.model.TransportSubtype
import com.google.gson.annotations.SerializedName


data class TransportSubtypeDto (

  @SerializedName("title" ) var title : String? = null,
  @SerializedName("code"  ) var code  : String? = null,
  @SerializedName("color" ) var color : String? = null

){
  fun toDomain() : TransportSubtype = TransportSubtype(title, code, color)
}