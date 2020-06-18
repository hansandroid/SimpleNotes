package com.hansandroid.simplenotes.presentation.di.component

import com.hansandroid.simplenotes.presentation.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {



}