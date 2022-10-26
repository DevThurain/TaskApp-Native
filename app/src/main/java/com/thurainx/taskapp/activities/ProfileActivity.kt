package com.thurainx.taskapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.thurainx.taskapp.R
import com.thurainx.taskapp.adapters.NormalTaskAdapter
import com.thurainx.taskapp.data.dummyProfileList
import com.thurainx.taskapp.data.dummyTaskList
import com.thurainx.taskapp.data.vos.TaskVO
import com.thurainx.taskapp.mvp.presenters.ProfilePresenter
import com.thurainx.taskapp.mvp.presenters.ProfilePresenterImpl
import com.thurainx.taskapp.mvp.views.ProfileView
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.view_holder_profile.*
import kotlinx.android.synthetic.main.view_pod_profile_section.*

const val EXTRA_PROFILE_ID = "EXTRA_PROFILE_ID"
class ProfileActivity : AppCompatActivity(), ProfileView {
    lateinit var mTaskAdapter: NormalTaskAdapter
    private val tabList = listOf("Project Tasks", "Contacts", "About You")

    lateinit var mProfilePresenter: ProfilePresenter

    companion object{
        fun getIntent(context: Context,profileId: Int) : Intent{
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra(EXTRA_PROFILE_ID, profileId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupPresenter()

        setupListener()
        setupTabLayout()
        setupRecyclerView()
        bindData()

        mProfilePresenter.onUiReady(this)
    }

    private fun setupPresenter(){
        mProfilePresenter = ViewModelProvider(this)[ProfilePresenterImpl::class.java]
        mProfilePresenter.initializeView(this)
    }

    private fun setupRecyclerView() {
        val image = dummyProfileList.filter { it.id == intent.getIntExtra(EXTRA_PROFILE_ID,1) }.first().profileImage
        dummyTaskList.forEach {
            it.profileImage = image
        }
        mTaskAdapter = NormalTaskAdapter(dummyTaskList)
        rvProfileTask.adapter = mTaskAdapter

    }

    private fun setupTabLayout() {
        tabList.forEach {
            tabLayoutProfile.newTab().apply {
                this.text = it
                tabLayoutProfile.addTab(this)
            }
        }
    }

    private fun bindData(){
        val profile = dummyProfileList.filter { it.id == intent.getIntExtra(EXTRA_PROFILE_ID,1) }.first()

        ivProfileCover.setImageResource(profile.profileImage)
        tvProfileName.text = profile.name
        tvProfilePosition.text = profile.position
    }

    private fun setupListener(){
        fabClose.setOnClickListener {
            mProfilePresenter.onTapClose()
        }
    }

    override fun navigateBack() {
        super.onBackPressed()
    }

    override fun showError(message: String) {
        Snackbar.make(window.decorView,message, Snackbar.LENGTH_SHORT).show()
    }
}