package org.techtown.crecker.mypage.report.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class IndiviualActivity : AppCompatActivity() {
    private var entries = arrayListOf<Entry>()
    private lateinit var lineData :LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_indiviual)
        var intent = intent

        inre_company_title_tv.text = intent.getStringExtra("company")
        inre_ad_tv.text = intent.getStringExtra("title")
        inre_viewcount.text = intent.getStringExtra("view_count")
        inre_like.text = intent.getStringExtra("like_count")
        mountingChart()

        inre_back_img.setOnClickListener {
            finish()
        }
    }

    private fun mountingChart(){
        entries = arrayListOf(
            Entry(0f,5f),
            Entry(1f,2f),
            Entry(2f,4f),
            Entry(3f,3f),
            Entry(4f,7f)
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
