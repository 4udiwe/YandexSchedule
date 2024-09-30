package com.example.data.model


import com.example.domain.model.Thread
import com.google.gson.annotations.SerializedName


data class ThreadDto(

    @SerializedName("uid") var uid: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("number") var number: String? = null,
    @SerializedName("short_title") var shortTitle: String? = null,
    @SerializedName("thread_method_link") var threadMethodLink: String? = null,
    @SerializedName("carrier") var carrier: CarrierDto? = CarrierDto(),
    @SerializedName("transport_type") var transportType: String? = null,
    @SerializedName("vehicle") var vehicle: String? = null,
    @SerializedName("transport_subtype") var transportSubtypeDto: TransportSubtypeDto? = TransportSubtypeDto(),
    @SerializedName("express_type") var expressType: String? = null

) {
    fun toDomain(): Thread = Thread(
        uid,
        title,
        number,
        shortTitle,
        threadMethodLink,
        carrier?.toDomain(),
        transportType,
        vehicle,
        transportSubtypeDto?.toDomain(),
        expressType
    )
}