package com.hansandroid.simplenotes.presentation.presenter

import com.hansandroid.simplenotes.data.NoteRepositoryImpl
import com.hansandroid.simplenotes.presentation.mvp.BasePresenter
import com.hansandroid.simplenotes.presentation.mvp.BaseView
import javax.inject.Inject

class NoteListPresenter @Inject constructor(private val repo: NoteRepositoryImpl) : BasePresenter<NoteListPresenter.View>(), {

    interface View : BaseView {
    }

    fun onAttach(view: View) {
        mView = view
    }

}