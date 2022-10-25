package com.thurainx.taskapp.views.components

import android.R.attr.bitmap
import android.R.attr.strokeWidth
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.withStyledAttributes
import com.thurainx.taskapp.R
import kotlin.math.roundToInt


class LineProgressIndicator @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var min = 0
    private var max = 100
    private var progress = 0
    private var progressBarThickness = 4.0f
    private var progressBarColor = Color.BLACK

    private var inactivePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var activePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        context.withStyledAttributes(attrs, R.styleable.LineProgressIndicator) {
            min = getInt(R.styleable.LineProgressIndicator_minLineValue, min)
            max = getInt(R.styleable.LineProgressIndicator_maxLineValue, max)
            progress = getInt(R.styleable.LineProgressIndicator_lineProgressValue, progress)
            progressBarThickness = getDimension(
                R.styleable.LineProgressIndicator_lineProgressBarThickness,
                progressBarThickness
            )
            progressBarColor =
                getColor(R.styleable.LineProgressIndicator_lineProgressBarColor, progressBarColor)
        }

        inactivePaint.color = calculateInactiveColor(progressBarColor, 0.3f)
        inactivePaint.strokeWidth = progressBarThickness

        activePaint.color = progressBarColor
        activePaint.strokeWidth = progressBarThickness

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(0f, height/2f, width.toFloat(), height/2f, inactivePaint)

        val progressValue = ((width * progress) / max).toFloat()
        Log.d("progress",progress.toString())
        canvas?.drawLine(0f, height/2f, progressValue, height/2f, activePaint)


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec)
        val width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec)
        setMeasuredDimension(width, height)
    }

    private fun calculateInactiveColor(color: Int, factor: Float) : Int {
        val alpha = (Color.alpha(color) * factor).roundToInt()
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)

        return Color.argb(alpha, red, green, blue)
    }

    fun setProgress(value: Int){
        progress = value
        invalidate()
    }
}