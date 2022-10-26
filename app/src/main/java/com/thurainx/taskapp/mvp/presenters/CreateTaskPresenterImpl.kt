package com.thurainx.taskapp.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.thurainx.taskapp.data.dummyCategoryList
import com.thurainx.taskapp.data.vos.CategoryVO
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.mvp.views.CreateTaskView

class CreateTaskPresenterImpl : CreateTaskPresenter, ViewModel() {
    var createTaskView: CreateTaskView? = null

    override fun initializeView(view: CreateTaskView) {
        createTaskView = view
    }



    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapProfile(profileVO: ProfileVO) {
        Log.d("profile",profileVO.id.toString())
        if(profileVO.id != 0){
            createTaskView?.navigateToProfileScreen(profileVO.id)
        }
    }

    override fun onTapCategory(categoryVO: CategoryVO) {
        dummyCategoryList.forEach {
            it.isSelected = it.id == categoryVO.id
        }

        createTaskView?.setNewCategoryList(dummyCategoryList)
    }

    override fun onTapBack() {
        createTaskView?.navigateBack()
    }
}