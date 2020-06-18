package com.hansandroid.simplenotes.domain.usecases

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.data.repository.NoteRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException

class AddNoteUseCase(private val repository: NoteRepository) {
    fun add(note: NoteModel): Completable = validate(note).andThen(repository.insertOrUpdate(note))

    private fun validate(note: NoteModel): Completable {
        return if (!note.isValidForAdd()) {
            Completable.error(IllegalArgumentException("note failed validation before add"))
        } else {
            Completable.complete()
        }
    }
}