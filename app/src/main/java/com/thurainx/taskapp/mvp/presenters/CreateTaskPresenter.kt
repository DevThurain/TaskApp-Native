package com.thurainx.taskapp.mvp.presenters

import com.thurainx.taskapp.delegates.CategoryDelegate
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.mvp.based.BasedPresenter
import com.thurainx.taskapp.mvp.views.CreateTaskView
import com.thurainx.taskapp.mvp.views.MainView

interface CreateTaskPresenter : BasedPresenter, ProfileDelegate, CategoryDelegate {
    fun initializeView(view: CreateTaskView)
    fun onTapBack()
}