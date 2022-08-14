package com.example.newsapp1.view.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp1.model.datamodel.PojoItemItem
import com.example.newsapp1.repository.PostRepository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestViewModel(val repository: PostRepository): ViewModel() {

    val postList = MutableLiveData<List<PojoItemItem>>()


    fun getAllData(){
        val response = repository.getPost()
        response.enqueue(object : Callback<List<PojoItemItem>> {
            override fun onResponse(
                call: Call<List<PojoItemItem>>,
                response: Response<List<PojoItemItem>>
            ) {
                postList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<PojoItemItem>>, t: Throwable) {
                Log.e("Fail", "${t.message}")
            }
        })
    }

}