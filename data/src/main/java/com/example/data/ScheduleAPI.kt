package com.example.data

import com.example.data.model.ScheduleDto
import retrofit2.http.GET
import retrofit2.http.Part

interface ScheduleAPI {

    @GET("?apikey=37e57a08-22bb-4b23-ab31-9654b5baa18b&from=c146&to=c213")
    suspend fun get() : ScheduleDto
}