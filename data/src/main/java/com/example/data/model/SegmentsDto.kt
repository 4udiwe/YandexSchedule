package com.example.data.model

import com.example.domain.model.Segments
import com.google.gson.annotations.SerializedName


data class SegmentsDto (

    @SerializedName("thread"             ) var thread            : ThreadDto? = ThreadDto(),
    @SerializedName("stops"              ) var stops             : String? = null,
    @SerializedName("from"               ) var from              : FromDto?= FromDto(),
    @SerializedName("to"                 ) var to                : ToDto?  = ToDto(),
    @SerializedName("departure_platform" ) var departurePlatform : String? = null,
    @SerializedName("arrival_platform"   ) var arrivalPlatform   : String? = null,
    @SerializedName("departure_terminal" ) var departureTerminal : String? = null,
    @SerializedName("arrival_terminal"   ) var arrivalTerminal   : String? = null,
    @SerializedName("duration"           ) var duration          : Int?    = null,
    @SerializedName("days"               ) var days              : String? = null,
    @SerializedName("except_days"        ) var exceptDays        : String? = null,
    @SerializedName("departure"          ) var departure         : String? = null,
    @SerializedName("arrival"            ) var arrival           : String? = null,
    @SerializedName("start_date"         ) var startDate         : String? = null

) {
    fun toDomain(): Segments = Segments(
        thread?.toDomain(),
        stops,
        from?.toDomain(),
        to?.toDomain(),
        departurePlatform,
        arrivalPlatform,
        departureTerminal,
        arrivalTerminal,
        duration,
        days,
        exceptDays,
        departure,
        arrival,
        startDate
    )
}