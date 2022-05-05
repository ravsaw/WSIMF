package com.example.wsimf

interface ProductListContract {
    interface View {
        fun showList(list: List<RowModel>)

        interface RowModel {
            var id: String
            var name: String
        }
    }

    interface Model {
        fun getList(): List<View.RowModel>
    }

    interface Presenter {
        fun onDestroy()
        fun requestList()
    }
}