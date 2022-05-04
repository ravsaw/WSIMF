package com.example.wsimf

class ProductListModel: ProductListContract.Model {

    override fun getList(): List<String> {
        return listOf("a","b","c","d")
    }

}