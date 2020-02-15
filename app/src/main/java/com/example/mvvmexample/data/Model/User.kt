package com.example.mvvmexample.data.Model

data class User(val imageUrl: String = "DEFAULT URL",
                val name: String = "DEFAULT NAME",
                val description: String = "DEFAULT DESCRIPTION",
                @field:JvmField
                val isAdmin: Boolean = false)