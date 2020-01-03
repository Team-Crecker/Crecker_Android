package org.techtown.crecker.mypage.notice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_notice.*
import org.techtown.crecker.R
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.putLog
import org.techtown.crecker.mypage.api.SettingServiceImpl
import org.techtown.crecker.mypage.contents.notice.NoticeAdapter
import org.techtown.crecker.mypage.contents.notice.NoticeData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeActivity : AppCompatActivity() {

    lateinit var adapter: NoticeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)

        adapter = NoticeAdapter(this@NoticeActivity)

        rv_notice.apply {
            adapter = this@NoticeActivity.adapter
            layoutManager = LinearLayoutManager(this@NoticeActivity, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(RcvItemDeco(this@NoticeActivity, false))
        }

        btn_goBack.setOnClickListener { finish() }

        SettingServiceImpl.service.getNotice().enqueue(object : Callback<NoticeData>{
            override fun onFailure(call: Call<NoticeData>, t: Throwable) {
                Toast.makeText(this@NoticeActivity, "서버와의 연결에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<NoticeData>, response: Response<NoticeData>) {
                response.isSuccessful.toString().putLog("dddd")
                response.takeIf { it.isSuccessful }?.body()?.data?.let {
                    it[0].title.putLog("dddd")
                    adapter.data = it as ArrayList<NoticeData.Data>
                    adapter.notifyDataSetChanged()
                    "여기까지".putLog("dddd")
                }
            }
        })
    }
}