package com.example.wsimf.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wsimf.ProductListContract
import com.example.wsimf.ProductListPresenter

/**
 * A fragment representing a list of Items.
 */
class ProductListFragment : Fragment(), ProductListContract.View {

    private var columnCount = 1
    private var productList = mutableListOf<ProductListContract.View.RowModel>()
    private var adapter: MyProductListRecyclerViewAdapter? = null

    private var presenter: ProductListContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = ProductListPresenter(this)
        presenter?.requestList()

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.product_fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyProductListRecyclerViewAdapter(productList)
            }
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ProductListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun showList(list: List<ProductListContract.View.RowModel>) {
        productList.clear()
        productList.addAll(list)
        adapter?.notifyDataSetChanged()
    }


}