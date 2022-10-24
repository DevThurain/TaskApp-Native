package com.thurainx.taskapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.taskapp.R
import com.thurainx.taskapp.adapters.ProfileAdapter
import com.thurainx.taskapp.data.dummyProfileList
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.views.components.OverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),ProfileDelegate {
    lateinit var mProfileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupProfileRecyclerView()
    }

    private fun setupProfileRecyclerView() {
        mProfileAdapter = ProfileAdapter(this)
        rvProfile.adapter = mProfileAdapter
        rvProfile.addItemDecoration(OverlapDecoration())
        
        mProfileAdapter.setNewData(dummyProfileList)

    }

    override fun onTapProfile(profileVO: ProfileVO) {
        TODO("Not yet implemented")
    }
}