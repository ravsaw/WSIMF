package com.example.wsimf

interface ProductListContract {
    interface View {
        fun showList(list: List<String>)
    }

    interface Model {
        fun getList(): List<String>
    }

    interface Presenter {
        fun onDestroy()
        fun requestList()
    }
}