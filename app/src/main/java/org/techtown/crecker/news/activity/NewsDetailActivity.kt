package org.techtown.crecker.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_news_detail.*
import org.techtown.crecker.R
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.news.api.NewsServiceImpl
import org.techtown.crecker.news.data.NewsDailyApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var glideManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        glideManager = Glide.with(this)
        var intent = intent
        var idx = intent.getIntExtra("Idx",0)
        startCommu(idx)

        news_detail_back.setOnClickListener {
            finish()
        }
    }

    private fun startCommu(idx : Int){
        val call : Call<NewsDailyApiData> = NewsServiceImpl.service.getDailyNews(idx)
        call.enqueue(
            object : Callback<NewsDailyApiData>{
                override fun onFailure(call: Call<NewsDailyApiData>, t: Throwable) {
                    "$t".debugLog("CallBackFailed in NewsDetail")
                }

                override fun onResponse(
                    call: Call<NewsDailyApiData>,
                    response: Response<NewsDailyApiData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            news_detail_title_tv.text = it[0].title
                            news_detail_sub_title_tv.text = it[0].subtitle
                            news_detail_day_tv.text = it[0].createAt
                            news_detail_content_tv.text = it[0].content
                            loading(it[0].thumbnail, news_detail_img)
                        }
                }
            }
        )
    }

    private fun loading(url : String, view : ImageView){
        view.post {
            glideManager.load(url).into(view)
        }
    }
}
