package com.thurainx.taskapp.data.vos

data class CategoryVO(
    val id: Int,
    val title: String,
    var isSelected: Boolean = false
) {
}