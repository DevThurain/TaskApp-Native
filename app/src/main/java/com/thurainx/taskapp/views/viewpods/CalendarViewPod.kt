package com.thurainx.taskapp.views.viewpods

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import com.thurainx.taskapp.utils.DateUtils
import kotlinx.android.synthetic.main.view_pod_calendar.view.*
import java.util.*

class CalendarViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

    lateinit var datePicker: MaterialDatePicker<Long>
    private var fragmentManager: FragmentManager? = null


    override fun onFinishInflate() {
        super.onFinishInflate()
        setupListeners()
    }

    fun setupViewPod(fragmentActivity: FragmentActivity){
        fragmentManager = fragmentActivity.supportFragmentManager
    }

    private fun setupListeners(){
        layoutViewPod.setOnClickListener {
            fragmentManager?.let {
                datePicker =
                    MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select Project Date")
                        .build()

                datePicker.show(it,"")

                datePicker.addOnPositiveButtonClickListener {

                  val selectedCalendar = Calendar.getInstance()
                  selectedCalendar.timeInMillis = datePicker.selection?.toLong() ?: 0


                tvCalendarDate.text = DateUtils.convertToReadableTime(selectedCalendar.time)
                }
            }

        }
    }
}