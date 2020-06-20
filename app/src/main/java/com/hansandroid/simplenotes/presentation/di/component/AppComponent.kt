package com.hansandroid.simplenotes.presentation.di.component

import com.hansandroid.simplenotes.presentation.di.PerApplication
import com.hansandroid.simplenotes.presentation.di.module.AppDbModule
import com.hansandroid.simplenotes.presentation.di.module.AppModule
import com.hansandroid.simplenotes.presentation.di.module.UseCaseModule
import com.hansandroid.simplenotes.presentation.view.fragment.NoteDetailFragment
import com.hansandroid.simplenotes.presentation.view.fragment.NotesListFragment
import dagger.Component

@PerApplication
@Component(modules = [AppDbModule::class, UseCaseModule::class, AppModule::class])
interface AppComponent {

    fun inject(fragment: NotesListFragment)
    fun inject(fragment: NoteDetailFragment)

}