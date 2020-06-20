package com.hansandroid.simplenotes.presentation

import android.app.Application
import com.hansandroid.simplenotes.presentation.di.component.AppComponent
import com.hansandroid.simplenotes.presentation.di.component.DaggerAppComponent
import com.hansandroid.simplenotes.presentation.di.module.AppModule

class SimpleNotesApp : Application() {

    lateinit var mComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    private fun createComponent() {
        val appModule = AppModule(this)
        mComponent = DaggerAppComponent.builder().appModule(appModule)
            .build()
    }

}