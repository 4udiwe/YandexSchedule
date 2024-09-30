package com.example.data.model


import com.example.domain.model.Thread
import com.google.gson.annotations.SerializedName


data class ThreadDto (

    @SerializedName("number"             ) var number           : String?              = null,
    @SerializedName("title"              ) var title            : String?              = null,
    @SerializedName("short_title"        ) var shortTitle       : String?              = null,
    @SerializedName("express_type"       ) var expressType      : String?              = null,
    @SerializedName("transport_type"     ) var transportType    : String?              = null,
    @SerializedName("carrier"            ) var carrier          : CarrierDto?          = CarrierDto(),
    @SerializedName("uid"                ) var uid              : String?              = null,
    @SerializedName("vehicle"            ) var vehicle          : String?              = null,
    @SerializedName("transport_subtype"  ) var transportSubtype : TransportSubtypeDto? = TransportSubtypeDto(),
    @SerializedName("thread_method_link" ) var threadMethodLink : String?              = null

) {
    fun toDomain(): Thread = Thread(
        number,
        title,
        shortTitle,
        expressType,
        transportType,
        carrier?.toDomain(),
        uid,
        vehicle,
        transportSubtype?.toDomain(),
        threadMethodLink
    )
}