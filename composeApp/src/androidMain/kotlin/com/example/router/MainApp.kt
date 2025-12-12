package com.example.router

import android.app.Application
import com.example.router.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainApp)
        }
    }
}