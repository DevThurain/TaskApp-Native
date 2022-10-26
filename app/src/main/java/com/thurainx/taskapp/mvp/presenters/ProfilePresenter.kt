package com.thurainx.taskapp.mvp.presenters

import com.thurainx.taskapp.mvp.based.BasedPresenter
import com.thurainx.taskapp.mvp.views.ProfileView

interface ProfilePresenter : BasedPresenter{
    fun initializeView(view: ProfileView)
    fun onTapClose()
}