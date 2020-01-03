package org.techtown.crecker.law

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amn.easysharedpreferences.EasySharedPreference
import kotlinx.android.synthetic.main.fragment_law.view.*

import org.techtown.crecker.R
import org.techtown.crecker.law.activity.LawActivity
import org.techtown.crecker.law.activity.QuestAcitivy
import org.techtown.crecker.law.adapter.ExpertBannerAdpater
import org.techtown.crecker.law.adapter.Expert_Betelang_Rv_Adp
import org.techtown.crecker.law.api.ExpertServiceImpl
import org.techtown.crecker.law.data.BetelangApiData
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.TokenObject
import org.techtown.crecker.module.debugLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LawFragment : Fragment() {
    private lateinit var betelangAdapter : Expert_Betelang_Rv_Adp
    var token = EasySharedPreference.getString("token", "") // 영속성 데이터

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_law, container, false)
        val mContext = V.context

        initFontChange(V) // 필독사항 텍스트 일부분 강조 함수
        initBanner(V) // Expert 대문 배너 생성 함수
        initBetelangRv(V,mContext) // 전문가 프로필 리사이클러뷰 함수

        V.expert_subtitle_law_tv.setOnClickListener {
            var intent = Intent(activity, LawActivity::class.java)
            startActivity(intent)
        }

        V.float_writing_btn.setOnClickListener {
            var intent = Intent(activity, QuestAcitivy::class.java)
            startActivity(intent)
        }

        return V
    }

    private fun initFontChange(V : View){
        var no1_title = "실명, 개인정보는 NO."
        var no2_title = "질문은 명확하게 1개만."
        var no3_title = "설명은 시간순서에 따라 구체적으로."
        var no4_title = "변호사 답변은 3일 이내에."

        var spanTitle = ArrayList<SpannableString>()

        spanTitle.add(SpannableString(no1_title))
        spanTitle.add(SpannableString(no2_title))
        spanTitle.add(SpannableString(no3_title))
        spanTitle.add(SpannableString(no4_title))


        spanTitle[0].setSpan(ForegroundColorSpan(Color.parseColor("#1ec695")),10,12,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanTitle[0].setSpan(StyleSpan(Typeface.BOLD), 10, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        spanTitle[1].setSpan(ForegroundColorSpan(Color.parseColor("#1ec695")),9,12,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanTitle[1].setSpan(StyleSpan(Typeface.BOLD), 10, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        spanTitle[2].setSpan(ForegroundColorSpan(Color.parseColor("#1ec695")),13,18,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanTitle[2].setSpan(StyleSpan(Typeface.BOLD), 13, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        spanTitle[3].setSpan(ForegroundColorSpan(Color.parseColor("#1ec695")),8,14,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spanTitle[3].setSpan(StyleSpan(Typeface.BOLD), 8, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        V.must_no_1_title_tv.text = spanTitle[0]
        V.must_no_2_title_tv.text = spanTitle[1]
        V.must_no_3_title_tv.text = spanTitle[2]
        V.must_no_4_title_tv.text = spanTitle[3]
    }
    private fun initBanner(V: View){
        val bannerAdp = ExpertBannerAdpater(V.context)
        bannerAdp.img_resource = listOf(R.drawable.img_law_banner,R.drawable.img_law_banner,R.drawable.img_law_banner)
        V.expert_viewpager.adapter = bannerAdp
    }
    private fun initBetelangRv(V : View, mContext : Context){
        "$token".debugLog("TokenFind")
        betelangAdapter = Expert_Betelang_Rv_Adp(mContext)
        V.expert_betelang_rv.adapter = betelangAdapter
        V.expert_betelang_rv.layoutManager = LinearLayoutManager(mContext)
        V.expert_betelang_rv.addItemDecoration(RcvItemDeco(mContext,false, 14))

        val call : Call<BetelangApiData> = ExpertServiceImpl.service.getBetelang()
        call.enqueue(
            object : Callback<BetelangApiData>{
                override fun onFailure(call: Call<BetelangApiData>, t: Throwable) {
                    Log.d("error","${t}")
                    Log.d("error","${call}")
                }

                override fun onResponse(
                    call: Call<BetelangApiData>,
                    response: Response<BetelangApiData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.takeIf { it.success == true }
                        ?.let {
                            betelangAdapter.data = it.data
                            betelangAdapter.notifyDataSetChanged()
                        }
                }
            }
        )
        "initBetelang".debugLog()
    }

}
