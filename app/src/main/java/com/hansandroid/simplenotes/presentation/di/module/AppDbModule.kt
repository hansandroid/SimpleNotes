package com.hansandroid.simplenotes.presentation.di.module

import android.content.Context
import com.hansandroid.simplenotes.data.NoteDao
import com.hansandroid.simplenotes.data.NoteModelMapperImpl
import com.hansandroid.simplenotes.data.NoteRepositoryImpl
import com.hansandroid.simplenotes.data.createNoteDao
import com.hansandroid.simplenotes.data.repository.NoteRepository
import com.hansandroid.simplenotes.presentation.di.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDbModule {

    @PerApplication
    @Provides
    fun provideNoteDao(context: Context) = createNoteDao(context)

    @PerApplication
    @Provides
    fun provideNoteModelMapper() = NoteModelMapperImpl()

    @PerApplication
    @Provides
    fun provideNoteRepository(noteDao: NoteDao, mapper: NoteModelMapperImpl): NoteRepository = NoteRepositoryImpl(noteDao, mapper)

}