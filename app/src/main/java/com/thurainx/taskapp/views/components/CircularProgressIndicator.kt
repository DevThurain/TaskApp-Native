package com.thurainx.taskapp.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.withStyledAttributes
import com.thurainx.taskapp.R
import kotlin.math.roundToInt

class CircularProgressIndicator @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var min = 0
    private var max = 100
    private var progress = 0
    private var progressBarThickness = 4.0f
    private var progressBarColor = Color.BLACK

    private var startAngle = -90f
    private var inactivePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var activePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var textPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var rectF = RectF()
    private var textRect = Rect()

    init {
        context.withStyledAttributes(attrs, R.styleable.CircularProgressIndicator){
            min = getInt(R.styleable.CircularProgressIndicator_min, min)
            max = getInt(R.styleable.CircularProgressIndicator_max, max)
            progress = getInt(R.styleable.CircularProgressIndicator_progress, progress)
            progressBarThickness = getDimension(R.styleable.CircularProgressIndicator_progressBarThickness, progressBarThickness)
            progressBarColor = getColor(R.styleable.CircularProgressIndicator_progressBarColor, progressBarColor)
        }

        inactivePaint.style = Paint.Style.STROKE
        inactivePaint.color = calculateInactiveColor(progressBarColor, 0.3f)
        inactivePaint.strokeWidth = progressBarThickness

        activePaint.style = Paint.Style.STROKE
        activePaint.color = progressBarColor
        activePaint.strokeWidth = progressBarThickness

        textPaint.color = progressBarColor
        textPaint.textAlign = Paint.Align.CENTER
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)


        val height = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec)
        val width = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec)
        val min = Math.min(width, height)
        setMeasuredDimension(min, min)


        Log.d("width", min.toString())

        rectF.set(
            progressBarThickness / 2,
            progressBarThickness / 2,
            min - (progressBarThickness / 2),
            min - (progressBarThickness / 2)
        )

        calculateTextSize(size = min)
        activePaint.getTextBounds(progress.toString().plus("%"),0,progress.toString().plus("%").length, textRect)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawOval(rectF, inactivePaint)

        val angle =(( 360 * progress) / max).toFloat()
        canvas?.drawArc(rectF, startAngle, angle,false, activePaint)

        canvas?.drawText(
            progress.toString().plus("%"),
            width / 2f,
            (height / 2f) - ((textPaint.descent() + textPaint.ascent()) / 2),
            textPaint
        )
    }

    private fun calculateInactiveColor(color: Int, factor: Float) : Int {
        val alpha = (Color.alpha(color) * factor).roundToInt()
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)

        return Color.argb(alpha, red, green, blue)
    }

    private fun calculateTextSize(size: Int){
        textPaint.textSize = size * 0.25f
    }

    fun setProgress(value: Int){
        progress = value
        invalidate()
    }


}