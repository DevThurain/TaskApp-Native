package com.thurainx.taskapp.delegates

import com.thurainx.taskapp.data.vos.CategoryVO

interface CategoryDelegate {
    fun onTapCategory(categoryVO: CategoryVO)
}