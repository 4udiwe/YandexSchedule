package com.example.yandexschedule.di

import com.example.yandexschedule.ScheduleViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<ScheduleViewModel> {
        ScheduleViewModel(getSchedule = get(), getSuggestions = get())
    }
}