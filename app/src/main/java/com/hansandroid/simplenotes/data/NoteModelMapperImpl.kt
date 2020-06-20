package com.hansandroid.simplenotes.data

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.data.repository.NoteModelMapper

class NoteModelMapperImpl :
    NoteModelMapper<NoteEntity, NoteModel> {
    override fun fromEntity(from: NoteEntity) = NoteModel(from.id, from.noteText, from.timestamp)


    override fun toEntity(from: NoteModel): NoteEntity {
        val a = 0
        return NoteEntity(from.id, from.noteText, System.currentTimeMillis())
    }

}