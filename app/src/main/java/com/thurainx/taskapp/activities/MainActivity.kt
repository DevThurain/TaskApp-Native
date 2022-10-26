package com.thurainx.taskapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.thurainx.taskapp.R
import com.thurainx.taskapp.adapters.ProfileAdapter
import com.thurainx.taskapp.data.dummyProfileList
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.mvp.presenters.MainPresenter
import com.thurainx.taskapp.mvp.presenters.MainPresenterImpl
import com.thurainx.taskapp.mvp.views.MainView
import com.thurainx.taskapp.views.components.OverlapDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {

    lateinit var mProfileAdapter: ProfileAdapter
    lateinit var mainPresenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
        setupProfileRecyclerView()
        mainPresenter.onUiReady(this)
    }

    private fun setupPresenter() {
        mainPresenter = ViewModelProvider(this)[MainPresenterImpl::class.java]
        mainPresenter.initializeView(this)
    }

    private fun setupProfileRecyclerView() {
        mProfileAdapter = ProfileAdapter(mainPresenter)
        rvProfile.adapter = mProfileAdapter
        rvProfile.addItemDecoration(OverlapDecoration())
        
        mProfileAdapter.setNewData(dummyProfileList)

    }

    override fun navigateToProfileScreen(profileId: Int) {
        startActivity(ProfileActivity.getIntent(this,profileId))
    }

    override fun navigateToCreateTaskScreen() {
        startActivity(CreateTaskActivity.getIntent(this))
    }

    override fun showError(message: String) {
        Snackbar.make(window.decorView,message, Snackbar.LENGTH_SHORT).show()
    }


}