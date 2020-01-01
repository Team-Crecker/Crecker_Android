package org.techtown.crecker.ads.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_apply.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.api.AdsServiceImpl
import org.techtown.crecker.ads.contents.data.PersonInfo
import org.techtown.crecker.ads.contents.data.PostResponse
import org.techtown.crecker.ads.fragment.putLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply)

        apply_tv_title.text = intent.getStringExtra("title")
        apply_tv_subtitle.text = intent.getStringExtra("subTitle")

        btn_goBack.setOnClickListener { finish() }
        apply_btn_plansheet.setOnClickListener { PlanSheetDialog().show() }

        apply_btn_apply.setOnClickListener {
            if(checkBlank())
                Toast.makeText(this, "빈칸을 모두 채워주세요!", Toast.LENGTH_SHORT).show()
            else{
                if(checkTerm()){
                    AlertDialog.Builder(this)
                        .setTitle("캠페인 신청 전 꼭 확인해주세요.")
                        .setMessage(R.string.campaign_check)
                        .setPositiveButton("확인") { _, _ ->
                            runPost()
                        }
                        .create()
                        .show()
                }
                else
                    Toast.makeText(this, "캠페인 미션 수행에 동의해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        AdsServiceImpl.service.getPersonInfo().enqueue(object : Callback<PersonInfo>{
            override fun onFailure(call: Call<PersonInfo>, t: Throwable) {
                "실패: $t".putLog("Fail")
            }

            override fun onResponse(call: Call<PersonInfo>, response: Response<PersonInfo>) {
                response.takeIf { it.isSuccessful }?.body()?.data?.
                    let {
                        apply_et_url.setText(it[0].youtubeUrl)
                        apply_et_phone.setText(it[0].phone)
                        apply_et_addr.setText(it[0].location)
                    } ?: run{
                    Toast.makeText(this@ApplyActivity, "서버로부터 정보를 받아올 수 없습니다..", Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

    private fun runPost() {
        val map = HashMap<String, Any>()
            .apply {
                put("title", apply_tv_title.text.toString())
                put("subtitle", apply_tv_subtitle.text.toString())
                put("refUrl", apply_et_ref_url.text.toString())
                put("youtubeUrl", apply_et_url.text.toString())
                put("phone", apply_et_phone.text.toString())
                put("location", apply_et_addr.text.toString())
                put("planTitle", apply_et_plan_title.text.toString())
                put("planContents", apply_et_content.text.toString())
            }
        AdsServiceImpl.service.postAdPlan(map).enqueue(object : Callback<PostResponse> {
            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                "실패: $t".putLog("Fail")
            }

            override fun onResponse(
                call: Call<PostResponse>,
                response: Response<PostResponse>
            ) {
                response.takeIf { it.isSuccessful }
                    ?.body()?.message.takeIf { it.equals("resMessage.INSERT_AD_SUCCESS") }
                    .let {
                        Toast.makeText(this@ApplyActivity, "신청 완료!", Toast.LENGTH_SHORT).show()
                        this@ApplyActivity.finish()
                    }
            }
        })
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

    private fun checkBlank(): Boolean =
        apply_et_url.text.isBlank() || apply_et_phone.text.isBlank()
                || apply_et_addr.text.isBlank() || apply_et_plan_title.text.isBlank()
                || apply_et_content.text.isBlank()

    private fun checkTerm(): Boolean = apply_checkBox_campaign.isChecked
}