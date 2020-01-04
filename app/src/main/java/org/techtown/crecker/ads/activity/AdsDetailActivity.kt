package org.techtown.crecker.ads.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_ads_detail.*
import kotlinx.android.synthetic.main.ad_campaign_intro.*
import kotlinx.android.synthetic.main.ad_detail_schedule.*
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

    var flag = false

    private lateinit var glideManager: RequestManager
    lateinit var loading: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads_detail)

        loading = ProgressDialog(this)
        loading.setTitle("데이터를 불러오는 중입니다..")
        loading.show()

        glideManager = Glide.with(this)

        AdsServiceImpl.service.getDetailInfo(intent.getIntExtra("idx", 1))
            .enqueue(object : Callback<Detail> {
                override fun onFailure(call: Call<Detail>, t: Throwable) {
                    "실패: $t".putLog("Fail")
                    loading.dismiss()
                    Toast.makeText(this@AdsDetailActivity, "데이터 로딩에 실패했습니다", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
                    response.takeIf { it.isSuccessful }?.body()?.data?.ad?.
                        let {
                            loadImg(it[0].thumbnail, detail_img_main)

                            ad_detail_title.text = it[0].title
                            ad_detail_desc.text = it[0].subtitle
                            textView9.text= it[0].cash
                            ad_detail_tv_apply_period.text = "${it[0].applyFrom} - ${it[0].applyTo}"
                            ad_detail_tv_select_day.text = it[0].choice
                            ad_detail_tv_upload_period.text = "${it[0].uploadFrom} - ${it[0].uploadTo}"
                            ad_detail_tv_complete_due.text = it[0].completeDate

                            shortImg = it[0].summaryPhoto
                            longImg = it[0].fullPhoto
                            loadImg(shortImg, ads_detail_desc_img)

                            ad_campaign_tv_creator_prefer.text = it[0].preference
                            ad_campaign_tv_campaign_intro.text = it[0].campaignInfo
                            ad_campaign_tv_site_url.text = it[0].url
                            ad_campaign_tv_providing.text = it[0].reward
                            ad_campaign_tv_search_keyword.text = it[0].keyword
                            ad_campaign_tv_mission.text = it[0].campaignMission
                            ad_campaign_tv_additional.text =it[0].addInfo

                            if(it[0].categoryCode != "0101"){
                                tv_sub.isGone = true
                                ad_detail_tv_subscriber_cnt.isGone = true
                            }
                            else{
                                ad_detail_tv_subscriber_cnt.text = it[0].subscribers
                                if(response.body()?.data?.subscribers!! < it[0].subscribersNum)
                                    flag = true
                            }

                        } ?: run{
                        Toast.makeText(this@AdsDetailActivity, "서버로부터 정보를 받아올 수 없습니다..", Toast.LENGTH_SHORT).show()
                    }
                    loading.dismiss()
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
            if(flag){
                Toast.makeText(this, "구독자 수가 부족합니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(
                    Intent(this, ApplyActivity::class.java)
                        .apply {
                            putExtra("title", ad_detail_title.text.toString())
                            putExtra("subTitle", ad_detail_desc.text.toString())
                            putExtra("Idx", intent.getIntExtra("idx",0))
                        })
            }
        }
    }

    fun loadImg(url: String, view: ImageView){
        view.post {
            glideManager.load(url).into(view)
        }
    }
}
