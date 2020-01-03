package org.techtown.crecker.news.activity

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_news_more.*
import org.techtown.crecker.R
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.api.NewsServiceImpl
import org.techtown.crecker.news.data.NewsApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsMoreActivity : AppCompatActivity() {

    private var scrap : Int = 0
    private lateinit var glideManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_more)
        glideManager = Glide.with(this)
        val intent = intent
        val idx = intent.getIntExtra("Idx",0)
        startCommu(idx)

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

    }

    private fun startCommu(idx : Int){
        val call = NewsServiceImpl.service.getSupportNewsMore(idx)
        call.enqueue(
            object : Callback<NewsApiData>{
                override fun onFailure(call: Call<NewsApiData>, t: Throwable) {
                    "$t".debugLog("CallBackFailed in MoreActivity")
                }

                override fun onResponse(call: Call<NewsApiData>, response: Response<NewsApiData>) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            it[0].let {
                                loading(it.poster,news_more_main_img)
                                news_more_company_tv.text = it.host
                                news_more_title_tv.text = it.title
                                news_more_subtitle_tv.text=it.subtitle
                                news_more_start_tv.text=it.calendarStart
                                news_more_end_tv.text = it.calendarEnd
                                news_more_program_tv.text = it.contents
                                news_more_place_tv.text = it.host
                                moveToUrl(it.url)
                            }
                        }
                }
            }
        )
    }

    private fun loading(url : String, view: ImageView){
        view.post {
            glideManager.load(url).into(view)
        }
    }

    private fun moveToUrl(url : String){
        this.news_more_sign_tv.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://${url}")))
        }
    }
}
