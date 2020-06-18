package com.hansandroid.simplenotes.data.repository

import com.hansandroid.simplenotes.domain.model.NoteModel
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface NoteRepository {

    fun insertOrUpdate(note: NoteModel): Completable

    fun delete(note: NoteModel): Completable

    fun findNoteById(id: Long): Maybe<NoteModel>

    fun getAllNotes(): Single<List<NoteModel>>

}