package com.thurainx.taskapp.data.vos

import android.graphics.Color
import com.thurainx.taskapp.R

data class TaskVO(
    val id: Int,
    val status: String,
    val title: String,
    val messageCount: Int,
    val attachmentCount: Int,
    var profileImage: Int = R.drawable.avatar1,
    val connected: Boolean = false,
    val taskColor: Int = R.color.color_dark_grey,
    val taskData: String,

)
