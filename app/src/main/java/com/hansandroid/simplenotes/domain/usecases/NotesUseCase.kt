package com.hansandroid.simplenotes.domain.usecases

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.data.repository.NoteRepository
import io.reactivex.Single

class NotesUseCase(private val repository: NoteRepository) {
    fun loadNotes(): Single<List<NoteModel>> = repository.getAllNotes()
}