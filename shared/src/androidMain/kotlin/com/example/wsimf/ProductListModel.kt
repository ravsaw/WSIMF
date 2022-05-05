package com.example.wsimf

class ProductListModel: ProductListContract.Model {

    override fun getList(): List<ProductListContract.View.RowModel> {
        return listOf(
            ProductListItem("a", "a"),
            ProductListItem("b", "B"),
            ProductListItem("c", "C"),
            ProductListItem("d", "d"),
            ProductListItem("e", "e"),
            ProductListItem("f", "f"),
        )
    }

}