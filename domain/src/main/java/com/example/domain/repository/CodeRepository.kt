package com.example.domain.repository

import com.example.domain.codemodel.Suggestions

interface CodeRepository {
    suspend fun getSuggestions(city: String) : Suggestions
}