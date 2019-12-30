package org.techtown.crecker.mypage.report.fragment


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.renderscript.Sampler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.fragment_total.view.*
import org.techtown.crecker.R
import org.techtown.crecker.module.debugLog
import com.github.mikephil.charting.formatter.ValueFormatter

class TotalFragment : Fragment() {

    private var entries = arrayListOf<Entry>()
    private lateinit var mView : View
    private lateinit var lineData: LineData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_total, container, false)
        mView = v
        initGraphData()
        return v
    }


    companion object {

        @JvmStatic
        fun newInstance() = TotalFragment()
    }

    private fun initGraphData() {
        entries.add(Entry(0f,5f))
        entries.add(Entry(1f,2f))
        entries.add(Entry(2f,4f))
        entries.add(Entry(3f,3f))
        entries.add(Entry(4f,7f))
        settingDataSet()
    }

    private fun settingDataSet() {
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

        mView.lineChart.data = lineData

        mView.lineChart.let {
            it.xAxis.position = XAxis.XAxisPosition.BOTTOM
            it.xAxis.axisLineColor =  Color.parseColor("#1EC695")
            it.xAxis.textColor = Color.parseColor("#1EC695")
            it.xAxis.setDrawGridLines(false)
////            it.xAxis.setDrawLabels(false)
////            it.xAxis.setDrawAxisLine(false)
            it.xAxis.granularity = 1f
//            it.xAxis.labelCount = 4
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
//        mView.lineChart.invalidate()
    }
}
