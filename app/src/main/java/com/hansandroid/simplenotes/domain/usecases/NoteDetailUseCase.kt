package com.hansandroid.simplenotes.domain.usecases

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.data.repository.NoteRepository
import io.reactivex.Maybe

class NoteDetailUseCase(private val repository: NoteRepository) {
    fun findNoteById(id: Long): Maybe<NoteModel> = repository.findNoteById(id)
}