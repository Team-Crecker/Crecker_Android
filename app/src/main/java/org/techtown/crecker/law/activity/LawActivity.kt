package org.techtown.crecker.law.activity

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_law.*
import kotlinx.android.synthetic.main.activity_quest.*
import kotlinx.android.synthetic.main.law_bottom_sheet.*
import org.techtown.crecker.R
import org.techtown.crecker.law.adapter.ExpertBannerAdpater
import org.techtown.crecker.law.adapter.ExpertLawRvAdp
import org.techtown.crecker.law.data.ExpertLawListData
import org.techtown.crecker.module.NavBarSetting
import org.techtown.crecker.module.RcvItemDeco

class LawActivity : AppCompatActivity() {
    private lateinit var lawListAdp : ExpertLawRvAdp

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_law)

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

        initBanner() // 배너 생성 및 오른쪽에만 이미지 살짝 보이게 하기
        initListRcv() // 하단 리사이클러 뷰 생성

    }

    private fun initBanner(){
        val bannerAdp = ExpertBannerAdpater(this)
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
        lawListAdp = ExpertLawRvAdp(this)
        law_qna_rcv.adapter = lawListAdp
        law_qna_rcv.layoutManager = LinearLayoutManager(this)
        law_qna_rcv.addItemDecoration(RcvItemDeco(this,false,14))
        lawListAdp.addItem(ExpertLawListData("답변완료",false,"답변 완료 + 공개글","답변 완료 + 공개글"))
        lawListAdp.addItem(ExpertLawListData("답변예정",false,"답변 예정 + 공개글","답변 예정 + 공개글"))
        lawListAdp.addItem(ExpertLawListData("답변완료",true,"답변 완료 + 비밀글","답변 완료 + 비밀글"))
        lawListAdp.addItem(ExpertLawListData("답변예정",true,"답변 예정 + 비밀글","답변 예정 + 비밀글"))


        lawListAdp.notifyDataSetChanged()
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
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.bottom_regi_tv.setOnClickListener {
            bottom_category_tv.text = "등록순"
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.bottom_inquery_tv.setOnClickListener {
            bottom_category_tv.text = "조회순"
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

