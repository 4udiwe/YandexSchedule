package com.example.domain.usecase

import com.example.domain.codemodel.Suggestions
import com.example.domain.repository.CodeRepository

class GetSuggestionsUseCase(
    private val codeRepository: CodeRepository
) {
    suspend fun invoke(city: String): Suggestions {
        return codeRepository.getSuggestions(city = city)
    }
}