package com.example.data.api

import com.example.data.model.ScheduleDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ScheduleAPI {
    @GET("?apikey=37e57a08-22bb-4b23-ab31-9654b5baa18b")
    suspend fun get(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("transport_types") transport: String,
        @Query("date") date: String
    ) : ScheduleDto
}