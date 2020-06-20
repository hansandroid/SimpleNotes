package com.hansandroid.simplenotes.presentation.view.interfaces

import com.hansandroid.simplenotes.domain.model.NoteModel

interface EditNoteContract {

    fun onLoadNoteSuccess(note: NoteModel)
    fun onEditNoteSuccess()
    fun onEditNoteError(throwable: Throwable)
    fun onNoteLookupError(throwable: Throwable)

}