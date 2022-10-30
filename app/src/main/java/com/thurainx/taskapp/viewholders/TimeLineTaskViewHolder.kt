package com.thurainx.taskapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.data.vos.TaskVO
import com.thurainx.taskapp.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.view_holder_normal_task.view.*
import kotlinx.android.synthetic.main.view_holder_timeline_task.view.*
import kotlinx.android.synthetic.main.view_holder_timeline_task.view.ivTaskProfile
import kotlinx.android.synthetic.main.view_holder_timeline_task.view.tvProfileStatus
import kotlinx.android.synthetic.main.view_holder_timeline_task.view.tvTaskAttachmentCount
import kotlinx.android.synthetic.main.view_holder_timeline_task.view.tvTaskMessageCount
import kotlinx.android.synthetic.main.view_holder_timeline_task.view.tvTaskTitle

class TimeLineTaskViewHolder(itemView: View, delegate: ProfileDelegate) : RecyclerView.ViewHolder(itemView) {

    var mProfile: ProfileVO? = null

    init {
        itemView.ivTaskProfile.setOnClickListener {
            mProfile?.let {
                delegate.onTapProfile(it)
            }
        }
    }

    fun bind(taskVO: TaskVO,upperPipeConnected: Boolean, lowerPipeConnected: Boolean, isFirst: Boolean){
        mProfile = taskVO.profile
        itemView.tvProfileStatus.text = taskVO.status
        when(taskVO.status){
            "Complete" ->{
                itemView.tvProfileStatus.setTextColor(itemView.context.getColor(R.color.color_dark_grey))
            }
            else ->{
                itemView.tvProfileStatus.setTextColor(itemView.context.getColor(R.color.color_accent_orange))
            }
        }



        if(upperPipeConnected){
            itemView.upperConnectionPipe.setBackgroundColor(itemView.context.getColor(R.color.white))
            if(isFirst){
                itemView.upperConnectionPipe.setBackgroundColor(itemView.context.getColor(R.color.color_transparent))
            }
        }else{
            itemView.upperConnectionPipe.setBackgroundColor(itemView.context.getColor(R.color.color_dark_grey))
            if(isFirst){
                itemView.upperConnectionPipe.setBackgroundColor(itemView.context.getColor(R.color.color_transparent))
            }
        }


        if(lowerPipeConnected){
            itemView.lowerConnectionPipe.setBackgroundColor(itemView.context.getColor(R.color.white))
        }else{
            itemView.lowerConnectionPipe.setBackgroundColor(itemView.context.getColor(R.color.color_dark_grey))
        }

        itemView.tvTaskTitle.text = taskVO.title
        itemView.tvTaskMessageCount.text = taskVO.messageCount.toString()
        itemView.tvTaskAttachmentCount.text = taskVO.attachmentCount.toString()
        itemView.ivTaskProfile.setImageResource(taskVO.profile.profileImage)
        itemView.ivCircleIndicator.setBackgroundColor(itemView.context.getColor(taskVO.taskColor))
        itemView.tvDataText.text = taskVO.taskData
    }


}