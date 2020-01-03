package org.techtown.crecker.mypage.report.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amn.easysharedpreferences.EasySharedPreference
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.activity_indiviual.*
import kotlinx.android.synthetic.main.fragment_total.*
import org.techtown.crecker.R
import org.techtown.crecker.module.TokenObject
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.mypage.report.api.ReportServiceImpl
import org.techtown.crecker.mypage.report.data.ReportDetailData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IndiviualActivity : AppCompatActivity() {
    private var entries = arrayListOf<Entry>()
    private lateinit var lineData :LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indiviual)
        var intent = intent
        var idx = intent.getIntExtra("Idx",0)

        startCommu(idx)

        inre_back_img.setOnClickListener {
            finish()
        }
    }

    private fun startCommu(idx : Int){
        val call : Call<ReportDetailData> = ReportServiceImpl.service.getDetailReport(idx)
        call.enqueue(
            object : Callback<ReportDetailData>{
                override fun onFailure(call: Call<ReportDetailData>, t: Throwable) {
                    "${t}".debugLog()
                }

                override fun onResponse(
                    call: Call<ReportDetailData>,
                    response: Response<ReportDetailData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            inre_company_title_tv.text = it[0].companyName
                            inre_ad_tv.text = it[0].title
                            inre_money.text = it[0].cash
                            inre_reward_num_tv.text = it[0].cash
                            inre_viewcount.text = it[0].views1.toString()
                            inre_like.text = it[0].likes.toString()

                            mountingChart(it[0].views1 ,it[0].views2, it[0].views3,
                                it[0].views4, it[0].views5)
                        }
                }
            }
        )
    }

    private fun mountingChart(y5 : Int, y4 : Int, y3 : Int, y2 : Int, y1 : Int){
        entries = arrayListOf(
            Entry(0f,y1.toFloat()),
            Entry(1f,y2.toFloat()),
            Entry(2f,y3.toFloat()),
            Entry(3f,y4.toFloat()),
            Entry(4f,y5.toFloat())
        )
        settingDataSet()
    }

    private fun settingDataSet(){
        val lineDataSet: LineDataSet = LineDataSet(entries,"조회수")

        lineDataSet.let {
            it.lineWidth = 4F
            it.circleRadius = 8F
            it.circleHoleRadius = 4F
            it.setCircleColor(Color.parseColor("#1EC695"))
            it.setColor(Color.parseColor("#1EC695"))
            it.fillColor = Color.parseColor("#1EC695")
            it.mode = LineDataSet.Mode.CUBIC_BEZIER
            it.setDrawFilled(true) // 밑에 색깔 칠하기
            it.setDrawValues(false)
            it.setDrawCircleHole(false)
            it.setDrawCircles(false)
        }
        lineData = LineData(lineDataSet)
        settingChart()
    }

    private fun settingChart(){
        val description = Description()
        description.text =""

        var formatter : ValueFormatter = object : ValueFormatter(){
            val mTime = arrayOf("00:00","5:00","10:00","15:00","23:59")
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                return mTime[value.toInt()]
            }
        }

        inre_graph.let{
            it.data = lineData
            it.xAxis.position = XAxis.XAxisPosition.BOTTOM
            it.xAxis.axisLineColor =  Color.parseColor("#1EC695")
            it.xAxis.textColor = Color.parseColor("#1EC695")
            it.xAxis.setDrawGridLines(false)
            it.xAxis.granularity = 1f
            it.xAxis.valueFormatter = formatter

            it.axisLeft.setDrawLabels(false)
            it.axisLeft.setDrawAxisLine(false)
            it.axisLeft.setDrawGridLines(false)

            it.axisRight.setDrawLabels(false)
            it.axisRight.setDrawAxisLine(false)
            it.axisRight.setDrawGridLines(false)

            it.description = description
            it.isDoubleTapToZoomEnabled = false
            it.animateY(1000, Easing.EaseInCubic)
            it.legend.setDrawInside(false)
        }
    }


}
