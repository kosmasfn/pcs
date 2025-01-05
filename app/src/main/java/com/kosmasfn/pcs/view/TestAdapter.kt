package com.kosmasfn.pcs.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.kosmasfn.core.base.BaseBindingAdapter
import com.kosmasfn.core.base.BaseBindingViewHolder
import com.kosmasfn.core.base.convertToLocalDateString
import com.kosmasfn.pcs.databinding.AdapterTestBinding
import com.kosmasfn.pcs.model.TestUIModel

class TestAdapter(private val onClick: ((data: TestUIModel) -> Unit)) :
    BaseBindingAdapter<BaseBindingViewHolder>() {

    private val listData = mutableListOf<TestUIModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(list: List<TestUIModel>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        listData.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder {
        return BaseBindingViewHolder(
            AdapterTestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun updateBinding(holder: BaseBindingViewHolder, binding: ViewBinding, position: Int) {
        val bind = binding as AdapterTestBinding
        val data = listData[position]

        Glide.with(bind.ivData.context)
            .load(data.avatar)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(bind.ivData)

        bind.tvName.text = data.name
        bind.tvCreatedAt.text = data.createdAt.convertToLocalDateString()
        bind.root.setOnClickListener {
            onClick.invoke(data)
        }
    }

    override fun getItemCount(): Int = listData.size
}