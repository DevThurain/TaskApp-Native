package com.thurainx.taskapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.thurainx.taskapp.R
import com.thurainx.taskapp.adapters.CategoryAdapter
import com.thurainx.taskapp.adapters.ProfileAdapter
import com.thurainx.taskapp.data.dummyCategoryList
import com.thurainx.taskapp.data.dummyProfileList
import com.thurainx.taskapp.data.vos.CategoryVO
import com.thurainx.taskapp.data.vos.ProfileVO
import com.thurainx.taskapp.delegates.CategoryDelegate
import com.thurainx.taskapp.delegates.ProfileDelegate
import com.thurainx.taskapp.mvp.presenters.CreateTaskPresenter
import com.thurainx.taskapp.mvp.presenters.CreateTaskPresenterImpl
import com.thurainx.taskapp.mvp.views.CreateTaskView
import com.thurainx.taskapp.views.components.OverlapDecoration
import com.thurainx.taskapp.views.viewpods.CalendarViewPod
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_main.*

class CreateTaskActivity : AppCompatActivity(), CreateTaskView {
    // adapters
    lateinit var mProfileAdapter: ProfileAdapter
    lateinit var mCategoryAdapter: CategoryAdapter

    // viewPods
    var viewPodStartDate: CalendarViewPod? = null
    var viewPodEndDate: CalendarViewPod? = null

    // presenter
    lateinit var mCreateTaskPresenter: CreateTaskPresenter

    companion object{
        fun getIntent(context: Context) : Intent {
            val intent = Intent(context, CreateTaskActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)


        setupPresenter()

        setupListeners()
        setupProfileRecyclerView()
        setupCategoryRecyclerView()
        setupViewPods()

        mCreateTaskPresenter.onUiReady(this)
    }

    private fun setupPresenter(){
        mCreateTaskPresenter = ViewModelProvider(this)[CreateTaskPresenterImpl::class.java]
        mCreateTaskPresenter.initializeView(this)
    }

    private fun setupListeners(){
        btnCreateTaskBack.setOnClickListener {
            mCreateTaskPresenter.onTapBack()
        }
    }

    private fun setupProfileRecyclerView() {
        mProfileAdapter = ProfileAdapter(mCreateTaskPresenter)
        rvAssignee.adapter = mProfileAdapter
        rvAssignee.addItemDecoration(OverlapDecoration())

        mProfileAdapter.setNewData(dummyProfileList)

    }

    private fun setupCategoryRecyclerView(){
        mCategoryAdapter = CategoryAdapter(mCreateTaskPresenter)
        rvCategory.adapter = mCategoryAdapter

        if(dummyCategoryList.isNotEmpty()){
            dummyCategoryList.first().isSelected = true
            mCategoryAdapter.setNewData(dummyCategoryList)
        }
    }

    private fun setupViewPods(){
        viewPodStartDate = vpStartDate as CalendarViewPod
        viewPodEndDate  = vpEndDate as CalendarViewPod

        viewPodStartDate?.setupViewPod(this)
        viewPodEndDate?.setupViewPod(this)
    }


    override fun navigateToProfileScreen(profileId: Int) {
        startActivity(ProfileActivity.getIntent(this,profileId))
    }

    override fun setNewCategoryList(categoryList: List<CategoryVO>) {
        mCategoryAdapter.setNewData(dummyCategoryList)
    }

    override fun navigateBack() {
        super.onBackPressed()
    }

    override fun showError(message: String) {
        Snackbar.make(window.decorView,message, Snackbar.LENGTH_SHORT).show()
    }

}