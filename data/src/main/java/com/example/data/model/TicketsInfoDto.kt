package com.example.data.model


import com.example.domain.model.TicketsInfo
import com.google.gson.annotations.SerializedName


data class TicketsInfoDto(

    @SerializedName("et_marker") var etMarker: Boolean? = null,
    @SerializedName("places") var places: ArrayList<PlacesDto> = arrayListOf()

) {
    fun toDomain(): TicketsInfo =
        TicketsInfo(etMarker, places.map { it.toDomain() } as ArrayList)
}