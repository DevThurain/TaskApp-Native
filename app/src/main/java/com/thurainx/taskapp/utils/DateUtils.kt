package com.thurainx.taskapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun convertToReadableTime(time: Date) : String{
        val formatter = SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)

        val parsedDate: Date = formatter.parse(time.toString())
        val print = SimpleDateFormat("MMM dd, yyyy")

        return print.format(parsedDate)

    }
}