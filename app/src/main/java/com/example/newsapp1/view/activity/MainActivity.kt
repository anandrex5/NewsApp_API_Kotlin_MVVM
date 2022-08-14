package com.example.newsapp1.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp1.R
import com.example.newsapp1.view.adapter.TestAdapter
import com.example.newsapp1.application.network.ApiClient
import com.example.newsapp1.application.network.ApiInterface
import com.example.newsapp1.databinding.ActivityMainBinding
import com.example.newsapp1.model.datamodel.PojoItemItem
import com.example.newsapp1.repository.PostRepository
import com.example.newsapp1.view.viewmodel.TestViewModel
import com.example.newsapp1.view.viewmodel.TestViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: TestViewModel

    var list: List<PojoItemItem> = ArrayList()

    val adapter = TestAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val apiInterface = ApiClient.getApiData()?.create(ApiInterface::class.java)

        val repository  = PostRepository(apiInterface!!)

        viewModel = ViewModelProvider(this, TestViewModelFactory(repository)).get(TestViewModel::class.java)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)



        viewModel.postList.observe(this, Observer {
            Log.d("TAG", "List: $it")
            adapter.setData(it)
        })



        viewModel.getAllData()



    }
}