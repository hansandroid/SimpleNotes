package com.hansandroid.simplenotes.presentation.view.interfaces

interface DeleteNoteContract {

    fun onDeleteNoteSuccess()
    fun onDeleteNoteError(throwable: Throwable)

}