package com.hansandroid.simplenotes.domain.usecases

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.data.repository.NoteRepository
import io.reactivex.Completable

class DeleteNoteUseCase(private val repository: NoteRepository) {

    fun delete(note: NoteModel): Completable = repository.delete(note)

}