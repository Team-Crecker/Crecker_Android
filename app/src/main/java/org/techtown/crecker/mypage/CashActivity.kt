package org.techtown.crecker.mypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cash.*
import org.techtown.crecker.R
import java.util.*

class CashActivity : AppCompatActivity() {
    private lateinit var adapter: UsageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)

        adapter = UsageAdapter(this)
        adapter.data = arrayListOf(
            UsageRecord(
                "시카솔 클렌징 워터",
                "입금",
                5000,
                Date()
            ),
            UsageRecord(
                "계좌 출금",
                "출금",
                5000,
                Date()
            ),
            UsageRecord(
                "시카솔 클렌징 워터",
                "입금",
                5000,
                Date()
            ),
            UsageRecord(
                "계좌 출금",
                "출금",
                5000,
                Date()
            )
        )
        rv_usage.adapter = this.adapter
        rv_usage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        btn_goBack.setOnClickListener { finish() }
    }
}
