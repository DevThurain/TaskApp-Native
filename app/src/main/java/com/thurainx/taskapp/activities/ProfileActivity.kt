package com.thurainx.taskapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.taskapp.R
import com.thurainx.taskapp.adapters.NormalTaskAdapter
import com.thurainx.taskapp.data.dummyProfileList
import com.thurainx.taskapp.data.dummyTaskList
import com.thurainx.taskapp.data.vos.TaskVO
import kotlinx.android.synthetic.main.activity_profile.*

const val EXTRA_PROFILE_ID = "EXTRA_PROFILE_ID"
class ProfileActivity : AppCompatActivity() {
    lateinit var mTaskAdapter: NormalTaskAdapter
    private val tabList = listOf("Project Tasks", "Contacts", "About You")

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

        setupTabLayout()
        setupRecyclerView()
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
}