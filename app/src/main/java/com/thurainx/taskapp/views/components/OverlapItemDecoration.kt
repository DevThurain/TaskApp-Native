package com.thurainx.taskapp.views.components

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class OverlapDecoration : ItemDecoration() {
    companion object {
        private const val vertOverlap = -25
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.set(vertOverlap, 0, 0, 0)
    }
}