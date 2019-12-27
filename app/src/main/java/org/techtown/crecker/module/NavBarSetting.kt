package org.techtown.crecker.module

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.util.DisplayMetrics
import androidx.annotation.RequiresApi

object NavBarSetting {
    @RequiresApi(Build.VERSION_CODES.M)
    fun setWhite(dialog: Dialog){
        val window = dialog.window

        if(window != null){
            val metrics = DisplayMetrics()
            window.windowManager.defaultDisplay.getMetrics(metrics)

            val windowBackGround = LayerDrawable(
                arrayOf(
                    GradientDrawable(),
                    GradientDrawable().apply {
                        shape = GradientDrawable.RECTANGLE
                        setColor(Color.WHITE)
                    }
                )
            ).apply { setLayerInsetTop(1, metrics.heightPixels) }

            window.setBackgroundDrawable(windowBackGround)
        }
    }
}