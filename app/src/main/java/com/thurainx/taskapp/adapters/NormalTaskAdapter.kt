package com.thurainx.taskapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.data.vos.TaskVO
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.viewholders.NormalTaskViewHolder


class NormalTaskAdapter(private val mTaskList: List<TaskVO>) : RecyclerView.Adapter<NormalTaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NormalTaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_normal_task,parent, false)
        return NormalTaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: NormalTaskViewHolder, position: Int) {
        holder.bind(mTaskList[position])
    }

    override fun getItemCount(): Int {
        return mTaskList.size
    }

}