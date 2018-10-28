package com.antonioleiva.weatherapp

import android.app.Application
import com.antonioleiva.weatherapp.ui.utils.DelegatesExtensions

class App : Application() {

    companion object {
        var instance: App by DelegatesExtensions.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}