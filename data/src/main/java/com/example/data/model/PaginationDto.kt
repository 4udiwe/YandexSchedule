package com.example.data.model

import com.example.domain.model.Pagination
import com.google.gson.annotations.SerializedName


data class PaginationDto (

  @SerializedName("total"  ) var total  : Int? = null,
  @SerializedName("limit"  ) var limit  : Int? = null,
  @SerializedName("offset" ) var offset : Int? = null

){
  fun toDomain() : Pagination = Pagination(total, limit, offset)
}