package com.thurainx.taskapp.data

import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.data.vos.TaskVO

val dummyProfileList = listOf(
    ProfileVO(
        id = 1,
        profileImage = R.drawable.avatar1,
        name = "Avatar One",
        position = "Developer"
    ),
    ProfileVO(
        id = 2,
        profileImage = R.drawable.avatar2,
        name = "Avatar Two",
        position = "UI/Ux"
    ),
    ProfileVO(
        id = 3,
        profileImage = R.drawable.avatar3,
        name = "Avatar Three",
        position = "Manager"
    ),
    ProfileVO(
        id = 0,
        profileImage = R.drawable.plus,
        name = "",
        position = ""
    ),
)

val dummyTaskList = listOf(
    TaskVO(
        id = 1,
        status = "In Progress",
        title = "Contact Page",
        messageCount = 5,
        attachmentCount = 2,
    ),
    TaskVO(
        id = 1,
        status = "In Progress",
        title = "Develop UI/UX",
        messageCount = 3,
        attachmentCount = 1,
    ),
    TaskVO(
        id = 1,
        status = "Complete",
        title = "Create Mobile Version",
        messageCount = 6,
        attachmentCount = 6,
    ),
    TaskVO(
        id = 1,
        status = "Complete",
        title = "Buttons, pop-up",
        messageCount = 1,
        attachmentCount = 2,
    ),
    TaskVO(
        id = 1,
        status = "Complete",
        title = "Develop Ios Version",
        messageCount = 3,
        attachmentCount = 5,
    ),
)