package com.hansandroid.simplenotes.domain.model


data class NoteModel(val id: Long = 0, val noteText: String = "") {

    fun isValidForEdit() = id > 0 && noteText.trim().length > 3

    fun isValidForAdd() = noteText.trim().length > 3
}