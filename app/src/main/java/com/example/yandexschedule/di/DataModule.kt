package com.example.yandexschedule.di

import com.example.data.ScheduleAPI
import com.example.data.repository.ScheduleRepositoryImpl
import com.example.domain.repository.ScheduleRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    factory<ScheduleRepository> {
        ScheduleRepositoryImpl(api = get())
    }

    single<ScheduleAPI> {

        val interseptor = HttpLoggingInterceptor()
        interseptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interseptor)
            .build()

        Retrofit.Builder()
            .baseUrl("https://api.rasp.yandex.net/v3.0/search/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ScheduleAPI::class.java)
    }
}
