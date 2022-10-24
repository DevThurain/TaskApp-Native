package com.thurainx.taskapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.taskapp.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent{
            val intent = Intent(context, ProfileActivity::class.java)
            return intent
        }
    }

    val tabList = listOf("Project Tasks", "Contacts", "About You")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupTabLayout()
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