package com.example.data.repository

import android.util.Log
import com.example.data.api.CodeApi
import com.example.data.codemodel.SuggestionsDto
import com.example.domain.codemodel.Suggestions
import com.example.domain.repository.CodeRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CodeRepositoryImpl(
    private val api: CodeApi
) : CodeRepository {

    //    override suspend fun getSuggestions(city: String): Suggestions {
//        val call = api.get(city)
//        var dto = SuggestionsDto()
//        call.enqueue(object : Callback<SuggestionsDto>{
//            override fun onResponse(
//                call: Call<SuggestionsDto>,
//                response: Response<SuggestionsDto>
//            ) {
//                dto = if (response.code() == 200){
//                    response.body()!!
//                } else {
//                    SuggestionsDto(totalFound = null)
//                }
//
//            }
//
//            override fun onFailure(call: Call<SuggestionsDto>, t: Throwable) {
//                dto = SuggestionsDto(totalFound = -1)
//            }
//
//        })
//        Log.d("RRR", "repository: $dto")
//        return dto.toDomain()
//    }
    override suspend fun getSuggestions(city: String): Suggestions {
        return api.get(city = city).toDomain()
    }
}