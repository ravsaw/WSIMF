package com.example.wsimf

class ProductListPresenter(view: ProductListContract.View)
    : BasePresenter<ProductListContract.View, ProductListContract.Model>(),
    ProductListContract.Presenter {

    init {
        attachView(view)
        attachModel(ProductListModel())
    }

    override fun requestList() {
        var list = model?.getList()
        if (list != null) {
            view?.showList(list)
        }
    }

}