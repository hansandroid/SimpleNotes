package com.hansandroid.simplenotes.presentation.presenter

import com.hansandroid.simplenotes.data.NoteRepositoryImpl
import com.hansandroid.simplenotes.domain.model.NoteModel
import com.hansandroid.simplenotes.domain.usecases.AddNoteUseCase
import com.hansandroid.simplenotes.domain.usecases.DeleteNoteUseCase
import com.hansandroid.simplenotes.domain.usecases.NotesUseCase
import com.hansandroid.simplenotes.presentation.mvp.BasePresenter
import com.hansandroid.simplenotes.presentation.mvp.BaseView
import com.hansandroid.simplenotes.presentation.view.interfaces.DeleteNoteContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NoteListPresenter @Inject constructor(private val noteUseCase: NotesUseCase,
                                            private val deleteNoteUseCase: DeleteNoteUseCase) : BasePresenter<NoteListPresenter.View>() {

    interface View : BaseView, DeleteNoteContract {
        fun onLoadNotesSuccess(notes: List<NoteModel>)
        fun onLoadNotesError(throwable: Throwable)
        fun onFabClicked()
    }

    fun loadNotes() {
        mDisposable.add(noteUseCase.loadNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturnItem(emptyList())
            .subscribe({mView?.onLoadNotesSuccess(it)}, {mView?.onLoadNotesError(it)})
        )
    }

    fun deleteNote(noteModel: NoteModel) {
        mDisposable.add(deleteNoteUseCase.delete(noteModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ mView?.onDeleteNoteSuccess() }, { mView?.onDeleteNoteError(it) }))
    }

}