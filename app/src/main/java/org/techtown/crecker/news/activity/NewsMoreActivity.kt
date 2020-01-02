package org.techtown.crecker.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_news_more.*
import org.techtown.crecker.R

class NewsMoreActivity : AppCompatActivity() {

    private var scrap : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_more)

        //뒤로가기
        news_more_back_img.setOnClickListener {
            finish()
        }
        //스크랩 버튼
        news_more_scrap_img.setOnClickListener {
            if(scrap == 0){
                Toast.makeText(this,"스크랩 되었습니다.",Toast.LENGTH_LONG)
                    .show()
                news_more_scrap_img.setImageResource(R.drawable.ic_scrapped)
                scrap=1
            }
            else{
                Toast.makeText(this,"스크랩 해제되었습니다.",Toast.LENGTH_LONG)
                    .show()
                news_more_scrap_img.setImageResource(R.drawable.ic_scrap)
                scrap=0
            }
        }

        news_more_sign_tv.setOnClickListener {
            Toast.makeText(this,"신청 되었습니다.", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
