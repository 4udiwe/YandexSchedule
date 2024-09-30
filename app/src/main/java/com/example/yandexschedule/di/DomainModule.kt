package com.example.yandexschedule.di

import com.example.domain.usecase.GetScheduleUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetScheduleUseCase> {
        GetScheduleUseCase(repository = get())
    }
}