package com.thurainx.taskapp.data.vos

import com.thurainx.taskapp.R

data class TaskVO(
    val id: Int,
    val status: String,
    val title: String,
    val messageCount: Int,
    val attachmentCount: Int,
    var profileImage: Int = R.drawable.avatar1,
)
