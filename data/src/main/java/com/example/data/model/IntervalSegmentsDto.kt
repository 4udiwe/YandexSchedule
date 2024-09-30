package com.example.data.model


import com.example.domain.model.IntervalSegments
import com.google.gson.annotations.SerializedName


data class IntervalSegmentsDto(

    @SerializedName("from") var from: FromDto? = FromDto(),
    @SerializedName("thread") var thread: ThreadDto? = ThreadDto(),
    @SerializedName("departure_platform") var departurePlatform: String? = null,
    @SerializedName("stops") var stops: String? = null,
    @SerializedName("departure_terminal") var departureTerminal: String? = null,
    @SerializedName("to") var to: ToDto? = ToDto(),
    @SerializedName("has_transfers") var hasTransfers: Boolean? = null,
    @SerializedName("tickets_info") var ticketsInfoDto: TicketsInfoDto? = TicketsInfoDto(),
    @SerializedName("duration") var duration: Int? = null,
    @SerializedName("arrival_terminal") var arrivalTerminal: String? = null,
    @SerializedName("start_date") var startDate: String? = null,
    @SerializedName("arrival_platform") var arrivalPlatform: String? = null

) {
    fun toDomain(): IntervalSegments = IntervalSegments(
        from?.toDomain(),
        thread?.toDomain(),
        departurePlatform,
        stops,
        departureTerminal,
        to?.toDomain(),
        hasTransfers,
        ticketsInfoDto?.toDomain(),
        duration,
        arrivalTerminal,
        startDate,
        arrivalPlatform
    )
}