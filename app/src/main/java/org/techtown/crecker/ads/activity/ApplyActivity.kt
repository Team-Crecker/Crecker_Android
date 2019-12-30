package org.techtown.crecker.ads.activity

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_apply.*
import org.techtown.crecker.R

class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        btn_goBack.setOnClickListener { finish() }
        apply_btn_plansheet.setOnClickListener { PlanSheetDialog().show() }

        apply_btn_apply.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("캠페인 신청 전 꼭 확인해주세요.")
                .setMessage(R.string.campaign_check)
                .setPositiveButton("확인") { _, _ ->
                    Toast.makeText(this, "신청 완료!", Toast.LENGTH_SHORT).show()
                    this.finish()
                }
                .create()
                .show()
        }

       /* AlertDialog.Builder(this)
            .setTitle("기획서 작성 전 꼭 확인해주세요.")
            .setMessage(R.string.plansheet_check)
            .create()
            .show()*/
    }

    inner class PlanSheetDialog : Dialog(this) {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            WindowManager.LayoutParams().apply {
                flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
                dimAmount = 0.8f
                window?.attributes = this
            }

            setContentView(R.layout.plansheet_dialog)
        }
    }
}