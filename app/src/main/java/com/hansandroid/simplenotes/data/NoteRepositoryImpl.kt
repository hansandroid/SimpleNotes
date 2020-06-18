package com.hansandroid.simplenotes.data

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.data.repository.NoteRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

class NoteRepositoryImpl(private val noteDao: NoteDao,
                         private val mapper: NoteModelMapperImpl) :
    NoteRepository {
    override fun insertOrUpdate(note: NoteModel): Completable = Completable.fromAction { noteDao.insertOrUpdate(mapper.toEntity(
        NoteModel()
    )) }

    override fun delete(note: NoteModel): Completable = Completable.fromAction { noteDao.delete(mapper.toEntity(note)) }

    override fun findNoteById(id: Long): Maybe<NoteModel> {
        return noteDao.findNoteById(id)
            .map { mapper.fromEntity(it) }
    }

    override fun getAllNotes(): Single<List<NoteModel>> {
        return noteDao.getAllNotes()
            .map { it.map(mapper::fromEntity) }
    }
}