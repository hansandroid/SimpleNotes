package com.hansandroid.simplenotes.presentation.di.module

import com.hansandroid.simplenotes.data.NoteRepositoryImpl
import com.hansandroid.simplenotes.domain.usecases.*
import com.hansandroid.simplenotes.presentation.di.PerApplication
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @PerApplication
    @Provides
    fun provideNotesUseCase(repo: NoteRepositoryImpl): NotesUseCase {
        return NotesUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideNoteDetailUseCase(repo: NoteRepositoryImpl): NoteDetailUseCase {
        return NoteDetailUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideEditNoteUseCase(repo: NoteRepositoryImpl): EditNoteUseCase {
        return EditNoteUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideDeleteNoteUseCase(repo: NoteRepositoryImpl): DeleteNoteUseCase {
        return DeleteNoteUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideAddNoteUseCase(repo: NoteRepositoryImpl): AddNoteUseCase {
        return AddNoteUseCase(repo)
    }
}