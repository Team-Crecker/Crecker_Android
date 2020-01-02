package org.techtown.crecker.mypage.cash

import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_cash.*
import kotlinx.android.synthetic.main.filtering_dialog_layout.*
import kotlinx.android.synthetic.main.layout_cash.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.fragment.putLog
import org.techtown.crecker.module.NavBarSetting
import org.techtown.crecker.mypage.api.CashServiceImpl
import org.techtown.crecker.mypage.contents.usage.CashData
import org.techtown.crecker.mypage.contents.usage.UsageAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class CashActivity : AppCompatActivity() {
    private lateinit var adapter: UsageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash)

        CashServiceImpl.service.getCashData().enqueue(object : Callback<CashData>{
            override fun onFailure(call: Call<CashData>, t: Throwable) {
                "실패: $t".putLog("Fail")
            }

            override fun onResponse(call: Call<CashData>, response: Response<CashData>) {
                initRV(response)

                response.takeIf { it.isSuccessful }?.body()?.data?.let {
                    tv_cash_have.setText(it.cash)
                    tv_cash_available.setText(it.cashAllowed)
                }

            }

            private fun initRV(response: Response<CashData>) {
                val l = response.takeIf { it.isSuccessful }
                    ?.body()?.data?.history as ArrayList<CashData.Data.History>

                adapter = UsageAdapter(this@CashActivity, l)
                rv_usage.adapter = adapter
                rv_usage.layoutManager =
                    LinearLayoutManager(this@CashActivity, LinearLayoutManager.VERTICAL, false)
            }
        })


        initListener()
    }

    private fun initListener() {
        btn_goBack.setOnClickListener { finish() }

        textView7.setOnClickListener { showFilter() }
        imageView4.setOnClickListener { showFilter() }

        btn_info.setOnClickListener { InfoDialog(this).show() }
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
                    adapter.filter.filter("적립")
                    this@CashActivity.textView7.text = "적립"
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
                    "적립" -> {
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
