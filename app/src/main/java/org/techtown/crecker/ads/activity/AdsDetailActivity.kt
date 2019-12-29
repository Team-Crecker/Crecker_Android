package org.techtown.crecker.ads.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ads_detail.*
import org.techtown.crecker.R

class AdsDetailActivity : AppCompatActivity() {

    var short = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads_detail)

        btn_goBack.setOnClickListener { finish() }
        ad_detail_see_more.setOnClickListener {
            if(short){
                ads_detail_desc_img.setImageResource(R.drawable.img_detail_long)
                ad_detail_see_more.text = "접기"
                short = false
            }
            else{
                ads_detail_desc_img.setImageResource(R.drawable.img_detail)
                ad_detail_see_more.text = "펼치기"
                short = true
            }
        }
        ad_detail_btn_apply.setOnClickListener {
            startActivity(
                Intent(this, ApplyActivity::class.java)
                .apply {
                    putExtra("title", ad_detail_title.text.toString())
                    putExtra("desc", ad_detail_desc.text.toString())
                })
        }
    }
}
