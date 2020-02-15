package com.example.mvvmexample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmexample.R
import com.example.mvvmexample.data.Model.User
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<User>()

    fun setListData(data: MutableList<User>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.
            from(context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0)
           dataList.size
        else
            0
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
    }

    inner class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(user: User){
            Glide.with(context).load(user.imageUrl).into(itemView.circleImageView)
            itemView.title.text = user.name
            itemView.description.text = user.description
            itemView.isAdmin.text = user.isAdmin.toString()
        }
    }
}