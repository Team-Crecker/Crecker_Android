package org.techtown.crecker.ads.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_ads_detail.*
import kotlinx.android.synthetic.main.ad_campaign_intro.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.api.AdsServiceImpl
import org.techtown.crecker.ads.contents.data.Detail
import org.techtown.crecker.ads.fragment.putLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdsDetailActivity : AppCompatActivity() {

    var short = true

    var shortImg = ""
    var longImg = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads_detail)

        AdsServiceImpl.service.getDetailInfo(intent.getIntExtra("idx", 1))
            .enqueue(object : Callback<Detail> {
                override fun onFailure(call: Call<Detail>, t: Throwable) {
                    "실패: $t".putLog("Fail")
                }

                override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                    response.takeIf { it.isSuccessful }?.body()?.data?.
                        let {
                            it[0]
                            loadImg(it[0].thumbnail, detail_img_main)

                            ad_detail_title.text = it[0].title
                            ad_detail_desc.text = it[0].subtitle
                            textView9.text= it[0].cash
                            //ad_detail_tv_apply_period
                            //ad_detail_tv_select_day
                            //ad_detail_tv_upload_period
                            //ad_detail_tv_complete_due

                            shortImg = it[0].summaryPhoto
                            longImg = it[0].fullPhoto
                            loadImg(shortImg, ads_detail_desc_img)

                            ad_campaign_tv_creator_prefer.text = it[0].preference
                            ad_campaign_tv_campaign_intro.text = it[0].campaignInfo
                            ad_campaign_tv_site_url.text = it[0].url
                            ad_campaign_tv_providing.text = it[0].reward
                            ad_campaign_tv_search_keyword.text = it[0].keyword
                            ad_campaign_tv_mission.text = it[0].campaignMission
                            //ad_campaign_tv_additional.text =it[0].addInfo

                        } ?: run{
                        Toast.makeText(this@AdsDetailActivity, "서버로부터 정보를 받아올 수 없습니다..", Toast.LENGTH_SHORT).show()
                    }
                }
            })

        btn_goBack.setOnClickListener { finish() }
        ad_detail_see_more.setOnClickListener {
            if(short){
                loadImg(shortImg, ads_detail_desc_img)
                ad_detail_see_more.text = "접기"
                short = false
            }
            else{
                loadImg(longImg, ads_detail_desc_img)
                ad_detail_see_more.text = "펼치기"
                short = true
            }
        }
        ad_detail_btn_apply.setOnClickListener {
            startActivity(
                Intent(this, ApplyActivity::class.java)
                .apply {
                    putExtra("title", ad_detail_title.text.toString())
                })
        }
    }

    fun loadImg(url: String, view: ImageView){
        Glide.with(this@AdsDetailActivity)
            .load(url)
            .into(view)
    }
}
