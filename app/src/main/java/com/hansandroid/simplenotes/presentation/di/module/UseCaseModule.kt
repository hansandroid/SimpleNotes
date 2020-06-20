package com.hansandroid.simplenotes.presentation.di.module

import com.hansandroid.simplenotes.data.NoteRepositoryImpl
import com.hansandroid.simplenotes.data.repository.NoteRepository
import com.hansandroid.simplenotes.domain.usecases.*
import com.hansandroid.simplenotes.presentation.di.PerApplication
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @PerApplication
    @Provides
    fun provideNotesUseCase(repo: NoteRepository): NotesUseCase {
        return NotesUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideEditNoteUseCase(repo: NoteRepository): EditNoteUseCase {
        return EditNoteUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideNoteDetailUseCase(repo: NoteRepository): NoteDetailUseCase {
        return NoteDetailUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideDeleteNoteUseCase(repo: NoteRepository): DeleteNoteUseCase {
        return DeleteNoteUseCase(repo)
    }

    @PerApplication
    @Provides
    fun provideAddNoteUseCase(repo: NoteRepository): AddNoteUseCase {
        return AddNoteUseCase(repo)
    }
}