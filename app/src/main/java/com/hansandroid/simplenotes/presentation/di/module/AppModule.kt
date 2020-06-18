package com.hansandroid.simplenotes.presentation.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppDbModule::class])
class AppModule(private val mApplication: Application) {

    @Provides
    @Singleton
    fun providesApplication() : Application {
        return mApplication
    }

}