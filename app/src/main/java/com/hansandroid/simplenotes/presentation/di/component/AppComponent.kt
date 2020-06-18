package com.hansandroid.simplenotes.presentation.di.component

import com.hansandroid.simplenotes.presentation.di.PerApplication
import com.hansandroid.simplenotes.presentation.di.module.AppDbModule
import com.hansandroid.simplenotes.presentation.di.module.UseCaseModule
import dagger.Component

@PerApplication
@Component(modules = [AppDbModule::class, UseCaseModule::class])
interface AppComponent {

}