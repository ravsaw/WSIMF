package com.example.wsimf.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.wsimf.Greeting
import android.widget.TextView
import com.example.wsimf.ProductListContract
import com.example.wsimf.ProductListPresenter


class ProductListActivity : AppCompatActivity(), ProductListContract.View {

    private var presenter: ProductListContract.Presenter? = null
    private lateinit var productList: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var button: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = ProductListPresenter(this)

        productList = findViewById(R.id.productList)
        button = findViewById(R.id.add_b)
        button.setOnClickListener {
            presenter?.requestList()
        }

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        productList.adapter = adapter

    }

    override fun onStart() {
        super.onStart()

        presenter?.requestList()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
        presenter = null
    }

    override fun showList(list: List<String>) {
        adapter.clear()
        adapter.addAll(list)
    }


}
