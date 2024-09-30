package com.example.data.model

import com.example.domain.model.Schedule
import com.google.gson.annotations.SerializedName


data class ScheduleDto(

    @SerializedName("pagination") var pagination: PaginationDto? = PaginationDto(),
    @SerializedName("interval_segments") var intervalSegments: ArrayList<IntervalSegmentsDto> = arrayListOf(),
    @SerializedName("segments") var segments: ArrayList<SegmentsDto> = arrayListOf(),
    @SerializedName("search") var search: SearchDto? = SearchDto()

) {
    fun toDomain(): Schedule =
        Schedule(pagination?.toDomain(), intervalSegments.map { it.toDomain() } as ArrayList)
}