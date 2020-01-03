package org.techtown.crecker.mypage.setting

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_select_ctg.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.fragment.putLog
import org.techtown.crecker.mypage.advertise.data.Interest
import org.techtown.crecker.mypage.api.Response
import org.techtown.crecker.mypage.api.SettingServiceImpl
import retrofit2.Call
import retrofit2.Callback

class SelectCtgActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_ctg)

        val span: Spannable = txt.text as Spannable
        span.setSpan(StyleSpan(Typeface.BOLD), 0, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        radioGroupChangeLogic()

        btn_goBack.setOnClickListener { finish() }

        btn_complete.setOnClickListener {
            SettingServiceImpl.service.putUserInterest(getInterest()).enqueue(object : Callback<Response> {
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    "실패: $t".putLog("Fail")
                    Toast.makeText(this@SelectCtgActivity, "실패", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    val msg = response.takeIf { it.isSuccessful }?.body()?.message
                    msg?.let {
                        Toast.makeText(this@SelectCtgActivity, it, Toast.LENGTH_SHORT).show()
                        finish()
                    }

                }
            })

        }

    }

    private fun getInterest(): Interest {
        val idAd = when (group_ad.checkedRadioButtonId) {
            R.id.rb_register_step3_ads_beauty -> "0101"
            R.id.rb_register_step3_ads_restu -> "0102"
            else -> "0103"
        }

        val idExpert = when (group_expert.checkedRadioButtonId) {
            R.id.rb_register_step3_expert_law -> "0201"
            R.id.rb_register_step3_expert_found -> "0202"
            else -> "0203"
        }

        val idSupport = when (group_support.checkedRadioButtonId) {
            R.id.rb_register_step3_support_edu -> "0301"
            R.id.rb_register_step3_support_contest -> "0302"
            else -> "0303"
        }


        val i = Interest(idAd, idExpert, idSupport)
        return i
    }

    private fun radioGroupChangeLogic() {
        group_ad.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){

                R.id.rb_register_step3_ads_beauty  -> {
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_beauty.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_restu  -> {
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_restu.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_travel  -> {
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_travel.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                }
            }
        }

        group_expert.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){

                R.id.rb_register_step3_expert_law  -> {
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_law.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_found.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_expert_found  -> {
                    rb_register_step3_expert_found.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_found.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_expert_shoot  -> {
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_shoot.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_found.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                }

            }
        }

        group_support.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){
                R.id.rb_register_step3_support_edu  -> {
                    rb_register_step3_support_edu.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_support_edu.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_support_fund.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_support_contest.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_support_fund  -> {
                    rb_register_step3_support_fund.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_support_fund.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_support_edu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_support_contest.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_support_contest  -> {
                    rb_register_step3_support_contest.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_support_contest.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_support_edu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_support_fund.setTextColor(Color.parseColor("#000000"))
                }

            }
        }
    }
}
