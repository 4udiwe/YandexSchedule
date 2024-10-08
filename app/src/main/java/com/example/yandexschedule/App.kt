package com.example.yandexschedule

import android.app.Application
import com.example.yandexschedule.di.appModule
import com.example.yandexschedule.di.dataModule
import com.example.yandexschedule.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}