package com.thurainx.taskapp.mvp.presenters

import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.mvp.based.BasedPresenter
import com.thurainx.taskapp.mvp.views.MainView

interface MainPresenter : BasedPresenter, ProfileDelegate {
    fun initializeView(view: MainView)
}