package com.hansandroid.simplenotes.data.repository

interface NoteModelMapper<E, M> {
    fun fromEntity(from: E) : M
    fun toEntity(from: M) : E
}