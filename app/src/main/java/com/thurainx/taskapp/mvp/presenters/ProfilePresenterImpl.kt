package com.thurainx.taskapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.thurainx.taskapp.mvp.views.ProfileView

class ProfilePresenterImpl: ProfilePresenter, ViewModel() {
    var profileView: ProfileView? = null

    override fun initializeView(view: ProfileView) {
        profileView = view
    }

    override fun onTapClose() {
        profileView?.navigateBack()
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }
}