package com.plcoding.jetpackcomposepokedex.data.remote.response

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class PokedexApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}