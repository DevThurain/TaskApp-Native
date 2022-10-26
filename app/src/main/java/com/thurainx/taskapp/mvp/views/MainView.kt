package com.thurainx.taskapp.mvp.views

import com.thurainx.taskapp.mvp.based.BasedView

interface MainView: BasedView{
    fun navigateToProfileScreen(profileId: Int)
    fun navigateToCreateTaskScreen()
}