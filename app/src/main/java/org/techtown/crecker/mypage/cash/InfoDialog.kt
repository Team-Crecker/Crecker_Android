package org.techtown.crecker.mypage.cash

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.info_dialog.*
import org.techtown.crecker.R

class InfoDialog(c: Context) : Dialog(c) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowManager.LayoutParams().apply {
            flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
            dimAmount = 0.8f
            window?.attributes = this
        }

        setContentView(R.layout.info_dialog)
        dialog_ok.setOnClickListener { this.dismiss() }
    }
}
