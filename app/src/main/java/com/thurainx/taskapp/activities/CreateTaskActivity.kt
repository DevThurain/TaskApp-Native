package com.thurainx.taskapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thurainx.taskapp.R

class CreateTaskActivity : AppCompatActivity() {
    companion object{
        fun getIntent(context: Context) : Intent {
            val intent = Intent(context, CreateTaskActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)
    }
}