package com.thurainx.taskapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.CategoryVO
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.CategoryDelegate
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.viewholders.CategoryViewHolder
import com.thurainx.taskapp.viewholders.ProfileViewHolder

class CategoryAdapter(val categoryDelegate: CategoryDelegate) : RecyclerView.Adapter<CategoryViewHolder>() {
    var mCategoryList: List<CategoryVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_category,parent, false)
        return CategoryViewHolder(view, categoryDelegate)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(mCategoryList[position])
    }

    override fun getItemCount(): Int {
        return mCategoryList.size
    }

    fun setNewData(categoryList: List<CategoryVO>){
        mCategoryList = categoryList
        notifyDataSetChanged()
    }
}