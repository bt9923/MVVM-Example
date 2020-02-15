package com.example.mvvmexample.ui.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.Network.Repo
import com.example.mvvmexample.data.Model.User

class MainViewModel: ViewModel() {

    private val repo = Repo()
    fun fetchUserData(): LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()

        repo.getUserData().observeForever{
            mutableData.value = it
        }

        return mutableData
    }
}