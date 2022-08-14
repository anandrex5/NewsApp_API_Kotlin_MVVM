package com.example.newsapp1.repository

import com.example.newsapp1.application.network.ApiInterface

class PostRepository( private val apiInterface: ApiInterface) {
    fun getPost() = apiInterface.getData()
}