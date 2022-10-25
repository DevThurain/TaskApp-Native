package com.thurainx.taskapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.thurainx.taskapp.R
import com.thurainx.taskapp.adapters.CategoryAdapter
import com.thurainx.taskapp.adapters.ProfileAdapter
import com.thurainx.taskapp.data.dummyCategoryList
import com.thurainx.taskapp.data.dummyProfileList
import com.thurainx.taskapp.data.vos.CategoryVO
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.CategoryDelegate
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.views.components.OverlapDecoration
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_main.*

class CreateTaskActivity : AppCompatActivity(), ProfileDelegate, CategoryDelegate {
    lateinit var mProfileAdapter: ProfileAdapter
    lateinit var mCategoryAdapter: CategoryAdapter

    companion object{
        fun getIntent(context: Context) : Intent {
            val intent = Intent(context, CreateTaskActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFTINPUAD)

        setupProfileRecyclerView()
        setupCategoryRecyclerView()
    }

    private fun setupProfileRecyclerView() {
        mProfileAdapter = ProfileAdapter(this)
        rvAssignee.adapter = mProfileAdapter
        rvAssignee.addItemDecoration(OverlapDecoration())

        mProfileAdapter.setNewData(dummyProfileList)

    }

    private fun setupCategoryRecyclerView(){
        mCategoryAdapter = CategoryAdapter(this)
        rvCategory.adapter = mCategoryAdapter

        if(dummyCategoryList.isNotEmpty()){
            dummyCategoryList.first().isSelected = true
            mCategoryAdapter.setNewData(dummyCategoryList)

        }
    }

    override fun onTapProfile(profileVO: ProfileVO) {

    }

    override fun onTapCategory(categoryVO: CategoryVO) {
        dummyCategoryList.forEach {
            it.isSelected = it.id == categoryVO.id
        }

        mCategoryAdapter.setNewData(dummyCategoryList)
    }

}