package com.thurainx.taskapp.views.components

import android.R.attr.shadowColor
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.core.content.withStyledAttributes
import com.thurainx.taskapp.R


class CircularImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {


    var path = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var strokeWidth = 2f
    var strokeColor = Color.BLACK

    var offsetX = -25
    var offsetY = 30
    var blurRadius = 5

    init {
        context.withStyledAttributes(attrs, R.styleable.CircularImageView){
            strokeWidth = getDimension(R.styleable.CircularImageView_strokeWidth, strokeWidth)
            strokeColor = getColor(R.styleable.CircularImageView_strokeColor, strokeColor)
        }
    }


    override fun onDraw(canvas: Canvas?) {

        //drawShadow(canvas)

        paint.color = strokeColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = strokeWidth

        val size = width.coerceAtMost(height)

        // draw border
        canvas?.drawCircle( (size / 2).toFloat(), (size / 2).toFloat(), ((size - strokeWidth) / 2),paint)

         //clip to circle
        path.addCircle((size / 2).toFloat(), (size / 2).toFloat(), ((size - (strokeWidth * 2)) / 2), Path.Direction.CW)
        canvas?.clipPath(path)

        super.onDraw(canvas)
    }

    fun drawShadow(canvas: Canvas?){
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.maskFilter = BlurMaskFilter(
            blurRadius.toFloat() /* shadowRadius */,
            BlurMaskFilter.Blur.NORMAL
        )
        val size = width.coerceAtMost(height)

        canvas?.drawCircle( (size / 2).toFloat(), (size / 2).toFloat(), ((size - strokeWidth) / 2),paint)
        paint.maskFilter = null
    }


}