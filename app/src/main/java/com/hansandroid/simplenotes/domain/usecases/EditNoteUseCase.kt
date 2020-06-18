package com.hansandroid.simplenotes.domain.usecases

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.data.repository.NoteRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException

class EditNoteUseCase(private val repository: NoteRepository) {

    fun edit(note: NoteModel): Completable = validate(note).andThen(repository.insertOrUpdate(note))

    fun validate(noteModel: NoteModel): Completable {
        return if (!noteModel.isValidForEdit()) {
            Completable.error(IllegalArgumentException("note failed validation before edit"))
        } else {
            Completable.complete()
        }
    }
}