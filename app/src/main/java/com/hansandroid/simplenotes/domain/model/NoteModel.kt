package com.hansandroid.simplenotes.domain.model

import java.util.*


data class NoteModel(val id: Long = 0, val noteText: String = "", val date: Long  = 0) {

    fun isValidForEdit() = id > 0 && noteText.trim().isNotEmpty()

    fun isValidForAdd() = noteText.trim().isNotEmpty()
}