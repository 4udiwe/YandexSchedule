package com.example.data.api

import com.example.data.codemodel.SuggestionsDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CodeApi {
    @GET("all_suggests?apikey=37e57a08-22bb-4b23-ab31-9654b5baa18b")
    suspend fun get(@Query("part") city: String) : SuggestionsDto
}