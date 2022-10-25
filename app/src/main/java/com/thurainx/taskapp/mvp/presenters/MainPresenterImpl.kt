package com.thurainx.taskapp.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.mvp.views.MainView

class MainPresenterImpl : MainPresenter, ViewModel() {
    var mainView: MainView? = null

    override fun initializeView(view: MainView) {
        mainView = view
    }

    override fun onUiReady(owner: LifecycleOwner) {

    }

    override fun onTapProfile(profileVO: ProfileVO) {
        Log.d("profile",profileVO.id.toString())
        if(profileVO.id != 0){
            mainView?.navigateToProfileScreen(profileVO.id)
        }
    }
}