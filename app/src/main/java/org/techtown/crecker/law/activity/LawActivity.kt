package org.techtown.crecker.law.activity

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.amn.easysharedpreferences.EasySharedPreference
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_law.*
import kotlinx.android.synthetic.main.law_bottom_sheet.*
import org.techtown.crecker.R
import org.techtown.crecker.law.adapter.ExpertBannerAdpater
import org.techtown.crecker.law.adapter.ExpertLawRvAdp
import org.techtown.crecker.law.api.ExpertServiceImpl
import org.techtown.crecker.law.data.QAdata
import org.techtown.crecker.module.NavBarSetting
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.debugLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LawActivity : AppCompatActivity() {
    private lateinit var lawListAdp : ExpertLawRvAdp
    private lateinit var answerList: List<QAdata.Data>

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_law)

        initBanner() // 배너 생성 및 오른쪽에만 이미지 살짝 보이게 하기
        initListRcv() // 하단 리사이클러 뷰 생성

        law_back_img.setOnClickListener{
            finish()
        }

        bottom_category_tv.setOnClickListener {
            changeBottomSheet()
        }

        float_quest_writing_btn.setOnClickListener {
            var intent = Intent(this, QuestAcitivy::class.java)
            startActivity(intent)
        }

    }

    private fun initBanner(){
        val bannerAdp = ExpertBannerAdpater(this)
        bannerAdp.img_resource = listOf(R.drawable.img_law_banner, R.drawable.img_law_banner, R.drawable.img_law_banner)
        law_banner_vp.adapter = bannerAdp

        var dpValue = 30
        val d : Float = resources.displayMetrics.density

        var margin : Int = (dpValue * d).toInt()
        law_banner_vp.run {
            clipToPadding = false
            setPadding(0, 0, margin, 0)
            offscreenPageLimit = bannerAdp.count
        }
    }

    private fun initListRcv(){
        var tooken = EasySharedPreference.getString("token", "") // 영속성 데이터
        lawListAdp = ExpertLawRvAdp(this)
        law_qna_rcv.adapter = lawListAdp
        law_qna_rcv.layoutManager = LinearLayoutManager(this)
        law_qna_rcv.addItemDecoration(RcvItemDeco(this,false,14))
        startCommu()
    }

    private fun startCommu(){
        val call : Call<QAdata> = ExpertServiceImpl.service.getLawAnswer()
        call.enqueue(
            object : Callback<QAdata>{
                override fun onFailure(call: Call<QAdata>, t: Throwable) {
                    "${t}".debugLog("CallBackFailed")
                }

                override fun onResponse(call: Call<QAdata>, response: Response<QAdata>) {
                    response?.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            lawListAdp.data = it.sortedBy { it.answerUpdateAt }.reversed()
                                    as MutableList<QAdata.Data>
                            answerList = it
                            lawListAdp.notifyDataSetChanged()

                        }
//                    Toast.makeText(this@LawActivity, "${response.body()?.statusCode}",
//                        Toast.LENGTH_LONG).show()
                }
            }
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun changeBottomSheet(){
        var text = bottom_category_tv.text.toString()
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.law_bottom_sheet)
        NavBarSetting.setWhite(bottomSheetDialog) // 바텀네비게이션 하얀색으로 변경
        bottomSheetDialog.show()

        bottomSheetDialog.bottom_answer_tv.setOnClickListener {
            bottom_category_tv.text = "답변순"
            lawListAdp.data.clear()
            law_qna_rcv.adapter = lawListAdp
            lawListAdp.data = answerList.sortedBy { it.answerUpdateAt }.reversed()
                    as MutableList<QAdata.Data>
            lawListAdp.notifyDataSetChanged()
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.bottom_regi_tv.setOnClickListener {
            bottom_category_tv.text = "등록순"
            lawListAdp.data.clear()
            law_qna_rcv.adapter = lawListAdp
            lawListAdp.data = answerList.sortedBy { it.createAt }.reversed()
                    as MutableList<QAdata.Data>
            lawListAdp.notifyDataSetChanged()
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.bottom_inquery_tv.setOnClickListener {
            bottom_category_tv.text = "조회순"
            lawListAdp.data.clear()
            law_qna_rcv.adapter = lawListAdp
            lawListAdp.data = answerList.sortedBy { it.views }.reversed()
                    as MutableList<QAdata.Data>
            lawListAdp.notifyDataSetChanged()
            bottomSheetDialog.dismiss()
        }

        when(text){
            "답변순" ->{
                bottomSheetDialog.bottom_answer_tv.typeface = Typeface.DEFAULT_BOLD
                bottomSheetDialog.bottom_regi_tv.typeface = Typeface.DEFAULT
                bottomSheetDialog.bottom_inquery_tv.typeface = Typeface.DEFAULT
            }
            "등록순" ->{
                bottomSheetDialog.bottom_answer_tv.typeface = Typeface.DEFAULT
                bottomSheetDialog.bottom_regi_tv.typeface = Typeface.DEFAULT_BOLD
                bottomSheetDialog.bottom_inquery_tv.typeface = Typeface.DEFAULT
            }
            "등록순" ->{
                bottomSheetDialog.bottom_answer_tv.typeface = Typeface.DEFAULT
                bottomSheetDialog.bottom_regi_tv.typeface = Typeface.DEFAULT
                bottomSheetDialog.bottom_inquery_tv.typeface = Typeface.DEFAULT_BOLD
            }
        }

    }

}

