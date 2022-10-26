package com.thurainx.taskapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.data.vos.TaskVO
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.viewholders.TimeLineTaskViewHolder


class TimeLineTaskAdapter(private val mTaskList: List<TaskVO>) :
    RecyclerView.Adapter<TimeLineTaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeLineTaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_timeline_task, parent, false)
        return TimeLineTaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeLineTaskViewHolder, position: Int) {
        holder.bind(
            mTaskList[position],
            isUpperConnectionPipeConnected(position),
            isLowerConnectionPipeConnected(position),
            position == 0
        )
    }

    override fun getItemCount(): Int {
        return mTaskList.size
    }

    private fun isUpperConnectionPipeConnected(position: Int): Boolean {
        if (mTaskList[position].connected) {
            if (position - 1 >= 0) {
                if (mTaskList[position].connected) return true
            }
        }
        return false
    }

    private fun isLowerConnectionPipeConnected(position: Int): Boolean {
        if (mTaskList[position].connected) {
            if (position + 1 < mTaskList.size) {
                if (mTaskList[position + 1].connected) return true
            }
        }
        return false
    }

}