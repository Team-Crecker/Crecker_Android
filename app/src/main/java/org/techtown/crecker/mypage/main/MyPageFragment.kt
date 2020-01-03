package org.techtown.crecker.mypage.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import kotlinx.android.synthetic.main.fragment_mypage.view.my_tv_cash
import kotlinx.android.synthetic.main.mypage_menu.view.*
import kotlinx.android.synthetic.main.rectangle.view.*

import org.techtown.crecker.R
import org.techtown.crecker.module.putLog
import org.techtown.crecker.mypage.advertise.activity.MyAdvertiseActivity
import org.techtown.crecker.mypage.advertise.data.BasicInfo
import org.techtown.crecker.mypage.api.UserAdServiceImpl
import org.techtown.crecker.mypage.cash.CashActivity
import org.techtown.crecker.mypage.notice.NoticeActivity
import org.techtown.crecker.mypage.report.ReportActivity
import org.techtown.crecker.mypage.scrap.ScrapActivity
import org.techtown.crecker.mypage.setting.SettingActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageFragment : Fragment() {
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mypage, container, false)

        initListener(v)

        UserAdServiceImpl.service.getBasicInfo().enqueue(object : Callback<BasicInfo> {
            override fun onFailure(call: Call<BasicInfo>, t: Throwable) {
                "UserAdService 실패".putLog()
            }

            override fun onResponse(call: Call<BasicInfo>, response: Response<BasicInfo>) {
                val data = response.takeIf { it.isSuccessful }?.body()?.data!!

                 v.my_tv_app.text = data.x1.toString()
                 v.my_tv_ass.text = data.x2.toString()
                 v.my_tv_check.text = data.x3.toString()
                 v.my_tv_fin.text = data.x4.toString()
            }
        })
        return v
    }

    private fun initListener(v: View) {
        v.btn_go_report.setOnClickListener {
            startActivity(Intent(mContext, ReportActivity::class.java))
        }
        v.btn_setting.setOnClickListener {
            startActivity(Intent(mContext, SettingActivity::class.java))
        }
        v.my_tv_cash.setOnClickListener {
            startActivity(Intent(mContext, CashActivity::class.java))
        }
        v.btn_showCash.setOnClickListener {
            startActivity(Intent(mContext, CashActivity::class.java))
        }
        v.imageView2.setOnClickListener {
            startActivity(Intent(mContext, CashActivity::class.java))
        }

        v.my_tv_app.setOnClickListener { goMyAdvertise(0) }
        v.my_tv_ass.setOnClickListener { goMyAdvertise(1) }
        v.my_tv_check.setOnClickListener { goMyAdvertise(2) }
        v.my_tv_fin.setOnClickListener { goMyAdvertise(3) }

        v.my_menu_scrap.setOnClickListener {
            startActivity(Intent(mContext, ScrapActivity::class.java))
        }

        v.my_menu_q.setOnClickListener {
            Toast.makeText(mContext, "준비중인 기능입니다", Toast.LENGTH_SHORT).show()
        }

        v.my_menu_q2.setOnClickListener {
            Toast.makeText(mContext, "준비중인 기능입니다", Toast.LENGTH_SHORT).show()
        }

        v.my_menu_consult_history.setOnClickListener {
            Toast.makeText(mContext, "준비중인 기능입니다", Toast.LENGTH_SHORT).show()
        }

        v.my_menu_faq.setOnClickListener {
            Toast.makeText(mContext, "준비중인 기능입니다", Toast.LENGTH_SHORT).show()
        }

        v.my_menu_notice.setOnClickListener {
            startActivity(Intent(mContext, NoticeActivity::class.java))
        }
    }

    private fun goMyAdvertise(idx: Int){
        mContext.startActivity(
            Intent(mContext, MyAdvertiseActivity::class.java)
                .apply {
                    putExtra("index", idx)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
        )
    }
}