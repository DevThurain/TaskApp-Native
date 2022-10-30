package com.thurainx.taskapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.TaskVO
import kotlinx.android.synthetic.main.view_holder_normal_task.view.*

class NormalTaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    init {

    }

    fun bind(taskVO: TaskVO){
        itemView.tvProfileStatus.text = taskVO.status
        when(taskVO.status){
            "Complete" ->{
                itemView.tvProfileStatus.setTextColor(itemView.context.getColor(R.color.color_dark_grey))
            }
            else ->{
                itemView.tvProfileStatus.setTextColor(itemView.context.getColor(R.color.color_accent_orange))
            }
        }

        itemView.tvTaskTitle.text = taskVO.title
        itemView.tvTaskMessageCount.text = taskVO.messageCount.toString()
        itemView.tvTaskAttachmentCount.text = taskVO.attachmentCount.toString()
        itemView.ivTaskProfile.setImageResource(taskVO.profile.profileImage)
    }


}