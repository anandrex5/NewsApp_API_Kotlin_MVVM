package com.example.newsapp1.application.network

import com.example.newsapp1.model.datamodel.PojoItemItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/beers")
    fun getData(): Call<List<PojoItemItem>>
}

