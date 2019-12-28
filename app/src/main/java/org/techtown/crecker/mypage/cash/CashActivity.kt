package org.techtown.crecker.mypage.cash

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_cash.*
import kotlinx.android.synthetic.main.filtering_dialog_layout.*
import org.techtown.crecker.R
import org.techtown.crecker.module.NavBarSetting
import org.techtown.crecker.mypage.contents.usage.UsageAdapter
import org.techtown.crecker.mypage.contents.usage.UsageRecord
import java.util.*

class CashActivity : AppCompatActivity() {
    private lateinit var adapter: UsageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)

        val init = arrayListOf(
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

        adapter = UsageAdapter(this, init)

        rv_usage.adapter = this.adapter
        rv_usage.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        btn_goBack.setOnClickListener { finish() }

        textView7.setOnClickListener { showFilter() }
        imageView4.setOnClickListener { showFilter() }

        btn_info.setOnClickListener {
            //커스텀 다이얼로그
        }
    }

    private fun showFilter() {
        val dialog = BottomSheetDialog(this)
            .apply {
                setContentView(R.layout.filtering_dialog_layout)
                category_all.setOnClickListener {
                    adapter.filter.filter("")
                    this@CashActivity.textView7.text = "전체"
                    dismiss()
                }
                category_deposit.setOnClickListener {
                    adapter.filter.filter("입금")
                    this@CashActivity.textView7.text = "입금"
                    dismiss()
                }
                category_withdraw.setOnClickListener {
                    adapter.filter.filter("출금")
                    this@CashActivity.textView7.text = "출금"
                    dismiss()
                }

                when(this@CashActivity.textView7.text.toString()){
                    "전체" -> {
                        category_all.typeface = Typeface.DEFAULT_BOLD
                        category_deposit.typeface = Typeface.DEFAULT
                        category_withdraw.typeface = Typeface.DEFAULT
                    }
                    "입금" -> {
                        category_all.typeface = Typeface.DEFAULT
                        category_deposit.typeface = Typeface.DEFAULT_BOLD
                        category_withdraw.typeface = Typeface.DEFAULT
                    }
                    "출금" -> {
                        category_all.typeface = Typeface.DEFAULT
                        category_deposit.typeface = Typeface.DEFAULT
                        category_withdraw.typeface = Typeface.DEFAULT_BOLD
                    }
                }
            }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1)
            NavBarSetting.setWhite(dialog)
        dialog.show()
    }
}
