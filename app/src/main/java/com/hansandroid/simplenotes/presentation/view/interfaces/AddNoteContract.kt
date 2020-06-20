package com.hansandroid.simplenotes.presentation.view.interfaces

interface AddNoteContract {
    fun onAddNoteSuccess()
    fun onNoteValidationFailed()
    fun onAddNoteError(throwable: Throwable)
}