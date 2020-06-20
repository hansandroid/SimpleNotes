package com.hansandroid.simplenotes.presentation.presenter

import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.domain.usecases.AddNoteUseCase
import com.hansandroid.simplenotes.domain.usecases.EditNoteUseCase
import com.hansandroid.simplenotes.domain.usecases.NoteDetailUseCase
import com.hansandroid.simplenotes.presentation.mvp.BasePresenter
import com.hansandroid.simplenotes.presentation.mvp.BaseView
import com.hansandroid.simplenotes.presentation.view.interfaces.AddNoteContract
import com.hansandroid.simplenotes.presentation.view.interfaces.EditNoteContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NoteDetailPresenter @Inject constructor(private val addNoteUseCase: AddNoteUseCase,
                                              private val editNoteUseCase: EditNoteUseCase,
                                              private val noteDetailUseCase: NoteDetailUseCase) : BasePresenter<NoteDetailPresenter.View>() {

    interface View : BaseView, AddNoteContract, EditNoteContract

    fun addNote(noteText: String) {
        mDisposable.add(addNoteUseCase.add(NoteModel(noteText = noteText))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ mView?.onAddNoteSuccess() }, this::onAddNoteError))
    }

    fun loadNote(id: Long) {
        mDisposable.add(noteDetailUseCase.findNoteById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ mView?.onLoadNoteSuccess(it) }, { mView?.onNoteLookupError(it) }))
    }

    fun editNote(id: Long, noteText: String) {
        mDisposable.add((editNoteUseCase.edit(NoteModel(id, noteText))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ mView?.onEditNoteSuccess() }, this::onEditNoteError)))
    }

    private fun onAddNoteError(throwable: Throwable) {
        when(throwable) {
            is IllegalArgumentException -> mView?.onNoteValidationFailed()
            else -> mView?.onAddNoteError(throwable)
        }
    }

    private fun onEditNoteError(throwable: Throwable) {
        when(throwable) {
            is IllegalArgumentException -> mView?.onNoteValidationFailed()
            else -> mView?.onEditNoteError(throwable)
        }
    }

}