package com.thurainx.taskapp.mvp.views

import com.thurainx.taskapp.data.vos.CategoryVO
import com.thurainx.taskapp.mvp.based.BasedView

interface CreateTaskView: BasedView{
    fun navigateToProfileScreen(profileId: Int)
    fun setNewCategoryList(categoryList: List<CategoryVO>)
    fun navigateBack()
}