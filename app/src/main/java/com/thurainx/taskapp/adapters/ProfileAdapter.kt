package com.thurainx.taskapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thurainx.taskapp.R
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.viewholders.ProfileViewHolder

class ProfileAdapter(val profileDelegate: ProfileDelegate) : RecyclerView.Adapter<ProfileViewHolder>() {
    var mProfileList: List<ProfileVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_profile,parent, false)
        return ProfileViewHolder(view, profileDelegate)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(mProfileList[position])
    }

    override fun getItemCount(): Int {
        return mProfileList.size
    }

    fun setNewData(profileList: List<ProfileVO>){
        mProfileList = profileList
        notifyDataSetChanged()
    }
}