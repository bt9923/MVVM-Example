package com.example.mvvmexample.ui.Main

import android.os.Bundle
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.R
import com.example.mvvmexample.ui.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private val viewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observeData()
    }

    private fun observeData(){
        shimmer_view_container.startShimmer() // If auto-start is set to false
        viewModel.fetchUserData().observe(this, Observer {
            shimmer_view_container.hideShimmer()
            shimmer_view_container.visibility = GONE
            shimmer_view_container.stopShimmer()
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}
