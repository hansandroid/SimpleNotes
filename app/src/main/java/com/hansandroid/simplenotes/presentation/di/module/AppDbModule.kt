package com.hansandroid.simplenotes.presentation.di.module

import android.content.Context
import com.hansandroid.simplenotes.data.NoteDao
import com.hansandroid.simplenotes.data.NoteModelMapperImpl
import com.hansandroid.simplenotes.data.NoteRepositoryImpl
import com.hansandroid.simplenotes.data.createNoteDao
import com.hansandroid.simplenotes.data.repository.NoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDbModule {

    @Singleton
    @Provides
    fun provideNoteDao(context: Context) = createNoteDao(context)

    @Singleton
    @Provides
    fun provideNoteModelMapper() = NoteModelMapperImpl()

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao, mapper: NoteModelMapperImpl): NoteRepository = NoteRepositoryImpl(noteDao, mapper)

}