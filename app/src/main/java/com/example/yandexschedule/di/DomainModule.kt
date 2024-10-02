package com.example.yandexschedule.di

import com.example.domain.usecase.GetScheduleUseCase
import com.example.domain.usecase.GetSuggestionsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetScheduleUseCase> {
        GetScheduleUseCase(repository = get())
    }
    factory<GetSuggestionsUseCase> {
        GetSuggestionsUseCase(codeRepository = get())
    }
}