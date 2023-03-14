package com.ztoais.nycschools

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SchoolApplication: Application() {

    override fun onCreate() {
        super.onCreate()

    }
}