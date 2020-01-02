package org.techtown.crecker.mypage.report.viewholder

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.module.formatMoney
import org.techtown.crecker.mypage.report.data.IndividualReportData

class IndividualReportVH (view: View) : RecyclerView.ViewHolder(view){
    private val category : TextView = view.findViewById(R.id.indi_category_tv)
    private val company : TextView = view.findViewById(R.id.indi_company_tv)
    private val title : TextView = view.findViewById(R.id.indi_title_tv)
    private val view_count : TextView = view.findViewById(R.id.indi_count)
    private val like_count : TextView = view.findViewById(R.id.indi_like)

    fun onBind(data : IndividualReportData){
        category.text = "#${data.category}"
        company.text = data.company
        title.text = data.ad_name
        view_count.text = data.view_count.formatMoney()
        like_count.text = data.like_count.formatMoney()

        itemView.setOnClickListener {
            Toast.makeText(itemView.context ,"${data.category}",Toast.LENGTH_LONG).show()
        }
    }
}