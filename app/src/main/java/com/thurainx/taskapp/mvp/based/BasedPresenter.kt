package com.thurainx.taskapp.mvp.based

import androidx.lifecycle.LifecycleOwner

interface BasedPresenter {
    fun onUiReady(owner: LifecycleOwner)
}