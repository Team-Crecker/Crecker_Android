package org.techtown.crecker.mypage.notice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notice_detail.*
import org.techtown.crecker.R
import org.techtown.crecker.mypage.api.SettingServiceImpl
import org.techtown.crecker.mypage.contents.notice.NoticeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_detail)

        btn_goBack.setOnClickListener { finish() }

        SettingServiceImpl.service.getDetailNotice(intent.getIntExtra("idx", 1))
            .enqueue(object : Callback<NoticeData>{
                override fun onFailure(call: Call<NoticeData>, t: Throwable) {
                }

                override fun onResponse(call: Call<NoticeData>, response: Response<NoticeData>) {
                    response.takeIf { it.isSuccessful }?.body()?.data?.let {
                        notice_detail_title.text = it[0].title
                        notice_detail_date.text = it[0].createAt.substring(0, 10)
                        notice_detail_content.text = it[0].content
                    }
                }
            })
    }
}
