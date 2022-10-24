package com.thurainx.taskapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.ProfileDelegate
import kotlinx.android.synthetic.main.view_holder_profile.view.*

class ProfileViewHolder(itemView: View, delegate: ProfileDelegate) :
    RecyclerView.ViewHolder(itemView) {

    var mProfile: ProfileVO? = null

    init {

        itemView.setOnClickListener {
            mProfile?.let {
                delegate.onTapProfile(it)
            }
        }

    }

    fun bind(profileVO: ProfileVO) {
        mProfile = profileVO
        itemView.ivProfileImage.setImageResource(profileVO.profileImage)
    }
}