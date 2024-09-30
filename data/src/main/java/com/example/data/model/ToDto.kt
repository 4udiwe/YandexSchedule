package com.example.data.model

import com.example.domain.model.To
import com.google.gson.annotations.SerializedName


data class ToDto (

  @SerializedName("type"              ) var type            : String? = null,
  @SerializedName("title"             ) var title           : String? = null,
  @SerializedName("short_title"       ) var shortTitle      : String? = null,
  @SerializedName("popular_title"     ) var popularTitle    : String? = null,
  @SerializedName("code"              ) var code            : String? = null,
  @SerializedName("station_type"      ) var stationType     : String? = null,
  @SerializedName("station_type_name" ) var stationTypeName : String? = null,
  @SerializedName("transport_type"    ) var transportType   : String? = null

){
  fun toDomain() : To = To(type, title, shortTitle, popularTitle, code, stationType, stationTypeName, transportType)
}