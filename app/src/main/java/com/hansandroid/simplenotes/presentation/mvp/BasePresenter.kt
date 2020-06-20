package com.hansandroid.simplenotes.presentation.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V: BaseView> : MvpPresenter {

    protected val mDisposable: CompositeDisposable = CompositeDisposable()
    protected var mView: V? = null

    fun attachView(view: V) {
        mView = view
    }

    override fun stop() {
        mView = null
    }

    override fun destroy() {
        mDisposable.clear()
    }

}