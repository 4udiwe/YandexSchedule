package com.example.data.model

import com.example.domain.model.Interval
import com.google.gson.annotations.SerializedName


data class IntervalDto(

    @SerializedName("density") var density: String? = null,
    @SerializedName("end_time") var endTime: String? = null,
    @SerializedName("begin_time") var beginTime: String? = null

) {
    fun toDomain(): Interval = Interval(density, endTime, beginTime)
}