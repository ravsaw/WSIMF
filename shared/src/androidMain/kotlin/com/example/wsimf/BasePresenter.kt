package com.example.wsimf


abstract class BasePresenter<T, Y> {
    protected var view: T? = null
    protected var model: Y? = null

    fun attachView(view: T) {
        this.view = view
    }
    fun detachView() {
        view = null
    }
    fun attachModel(model: Y) {
        this.model = model
    }
    fun detachModel() {
        model = null
    }
    open fun onDestroy() {
        detachView()
        detachModel()
    }
}
