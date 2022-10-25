package com.thurainx.taskapp.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.CategoryVO
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.CategoryDelegate
import com.thurainx.taskapp.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.view_holder_category.view.*

class CategoryViewHolder(itemView: View, delegate: CategoryDelegate) :
    RecyclerView.ViewHolder(itemView) {

    var mCategory: CategoryVO? = null

    init {

        itemView.setOnClickListener {
            mCategory?.let {
                delegate.onTapCategory(it)
            }
        }

    }

    fun bind(categoryVO: CategoryVO) {
        mCategory = categoryVO
        itemView.tvCategoryName.text = categoryVO.title.toString()

        if(categoryVO.isSelected) {
            itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.bg_category_active)
            itemView.ivCheck.visibility = View.VISIBLE
            itemView.tvCategoryName.setTextColor(itemView.context.getColor(R.color.white))
        }else{
            itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.bg_category_inactive)
            itemView.ivCheck.visibility = View.GONE
            itemView.tvCategoryName.setTextColor(itemView.context.getColor(R.color.color_primary))

        }
    }
}