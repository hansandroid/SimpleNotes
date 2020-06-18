package com.hansandroid.simplenotes.presentation

import android.app.Application
import com.hansandroid.simplenotes.presentation.di.component.AppComponent

class SimpleNotesApp : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

    }

}