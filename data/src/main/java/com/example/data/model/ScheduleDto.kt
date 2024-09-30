package com.example.data.model


import com.example.domain.model.Schedule
import com.google.gson.annotations.SerializedName


data class ScheduleDto (

  @SerializedName("search"            ) var search           : SearchDto?             = SearchDto(),
  @SerializedName("segments"          ) var segments         : ArrayList<SegmentsDto> = arrayListOf(),
  @SerializedName("interval_segments" ) var intervalSegments : ArrayList<String>      = arrayListOf(),
  @SerializedName("pagination"        ) var pagination       : PaginationDto?         = PaginationDto()

) {
  fun toDomain(): Schedule = Schedule(
    search?.toDomain(),
    segments.map { it.toDomain() } as ArrayList,
    intervalSegments,
    pagination?.toDomain())
}