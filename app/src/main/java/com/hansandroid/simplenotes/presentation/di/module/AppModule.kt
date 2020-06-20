package com.hansandroid.simplenotes.presentation.di.module

import android.content.Context
import com.hansandroid.simplenotes.presentation.di.PerApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val appContext: Context) {

    @PerApplication
    @Provides
    fun provideAppContext() = appContext

}