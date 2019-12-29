package org.techtown.crecker.ads.activity

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_apply.*
import kotlinx.android.synthetic.main.info_dialog.*
import org.techtown.crecker.R

class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        btn_goBack.setOnClickListener { finish() }
        apply_btn_plansheet.setOnClickListener { PlanSheetDialog().show() }


        AlertDialog.Builder(this)
            .setTitle("캠페인 신청 전 꼭 확인해주세요.")
            .setMessage("크레커를 통해 제작된 리뷰 콘텐츠 내용에는 대가성 문구가 반드시 포함되어 있어야 합니다.")
            .create()
            .show()
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
            dialog_ok.setOnClickListener { this.dismiss() }
        }
    }
}