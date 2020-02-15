package com.example.mvvmexample.data.Network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample.data.Model.User
import com.google.firebase.firestore.FirebaseFirestore

class Repo {
    fun getUserData(): LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        FirebaseFirestore.getInstance().collection("Users").addSnapshotListener{result, e ->
            val listData = mutableListOf<User>()
            for(document in result!!){
//                val imageUrl = document.getString("imageUrl")
//                val name = document.getString("name")
//                val description = document.getString("description")
//                val isAdmin = document.getBoolean("isAdmin")
//
//                val user = User(
//                    imageUrl!!,
//                    name!!,
//                    description!!,
//                    isAdmin!!
//                )

                listData.add(document.toObject(User::class.java))
            }

            mutableData.value = listData
        }

        return mutableData
    }
}