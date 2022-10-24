package com.thurainx.taskapp.delegates

import com.thurainx.taskapp.data.vos.ProfileVO

interface ProfileDelegate {
    fun onTapProfile(profileVO: ProfileVO)
}