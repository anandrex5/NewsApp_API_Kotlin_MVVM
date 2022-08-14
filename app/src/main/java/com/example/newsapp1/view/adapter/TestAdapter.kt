package com.example.newsapp1.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp1.R
import com.example.newsapp1.databinding.ItemBinding
import com.example.newsapp1.model.datamodel.PojoItemItem


class TestAdapter (var list: List<PojoItemItem>): RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    var dataBinding: ItemBinding? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        dataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item, parent, false
        )
        return ViewHolder(dataBinding!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: PojoItemItem = list[position]
        holder.bindData(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(data: List<PojoItemItem>) {
        this.list = data
        notifyDataSetChanged()
    }


    class ViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(pojoitem: PojoItemItem) {

            Glide.with(itemView.context)
                .load(pojoitem.image_url)
                .into(binding.itemImage)

            binding.tagline.text = pojoitem.tagline
            binding.title.text = pojoitem.name
//            binding.tagline.text = pojoitem.volume.toString()
            binding.itemDescription.text = pojoitem.description
        }
    }
}
