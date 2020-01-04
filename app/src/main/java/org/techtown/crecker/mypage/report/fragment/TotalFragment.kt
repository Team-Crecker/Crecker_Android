package org.techtown.crecker.mypage.report.fragment


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.amn.easysharedpreferences.EasySharedPreference
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
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.TokenObject
import org.techtown.crecker.module.formatMoney
import org.techtown.crecker.mypage.report.adapter.RatingRvAdp
import org.techtown.crecker.mypage.report.api.ReportServiceImpl
import org.techtown.crecker.mypage.report.data.TotalData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TotalFragment : Fragment() {

    private var entries = arrayListOf<Entry>()
    private lateinit var mView : View
    private lateinit var lineData: LineData
    private lateinit var ratingAdp : RatingRvAdp
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_total, container, false)
        mView = v
        startCommu()
        return v
    }

    private fun startCommu(){
        val call : Call<TotalData> = ReportServiceImpl.service.getTotalReport()
        call.enqueue(
            object : Callback<TotalData>{
                override fun onFailure(call: Call<TotalData>, t: Throwable) {
                    "${t}".debugLog("CallBackFailed")
                }

                override fun onResponse(call: Call<TotalData>, response: Response<TotalData>) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.takeIf { it.success == true }
                        ?.data
                        ?.let{
                            formattingNum(it.totalViews, it.totalLikes, it.totalCosts
                                ,it.er)

                            initGraphData(it.totalViews1, it.totalViews2, it.totalViews3,
                                it.totalViews4, it.totalViews5)

                            mountingRv(mView.context, it.top)
                        }
                }
            }
        )
    }

    companion object {

        @JvmStatic
        fun newInstance() = TotalFragment()
    }
    private fun formattingNum(viewCount : Int, like : Int, cost: Int, er: Int){
         mView.total_viewcount_tv.text = viewCount.formatMoney()
         mView.total_like_tv.text = like.formatMoney()
         mView.total_money_tv.text = cost.formatMoney()
         mView.total_avr_tv.text = er.toString()

    }

    private fun initGraphData(y1 : Int, y2 : Int, y3 : Int, y4 : Int, y5 : Int) {
        entries.add(Entry(0f,y5.toFloat()))
        entries.add(Entry(1f,y4.toFloat()))
        entries.add(Entry(2f,y3.toFloat()))
        entries.add(Entry(3f,y2.toFloat()))
        entries.add(Entry(4f,y1.toFloat()))
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

    private fun mountingRv(context : Context, data : List<TotalData.Data.Top>){
        ratingAdp = RatingRvAdp(context)
        mView.report_rating_rv.let {
            it.adapter = ratingAdp
            it.layoutManager = LinearLayoutManager(context)
            it.addItemDecoration(RcvItemDeco(context))
        }
        ratingAdp.data = data
        ratingAdp.notifyDataSetChanged()
    }
}
