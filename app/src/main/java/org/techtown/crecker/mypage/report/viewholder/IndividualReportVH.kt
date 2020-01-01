package org.techtown.crecker.mypage.report.viewholder

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.module.formatMoney
import org.techtown.crecker.mypage.report.activity.IndiviualActivity
import org.techtown.crecker.mypage.report.data.IndividualReportData

class IndividualReportVH (view: View) : RecyclerView.ViewHolder(view){
    private val category : TextView = view.findViewById(R.id.indi_category_tv)
    private val company : TextView = view.findViewById(R.id.indi_company_tv)
    private val title : TextView = view.findViewById(R.id.indi_title_tv)
    private val view_count : TextView = view.findViewById(R.id.indi_count)
    private val like_count : TextView = view.findViewById(R.id.indi_like)

    fun onBind(data : IndividualReportData){
        val count = data.view_count.formatMoney()
        val like = data.like_count.formatMoney()
        category.text = "#${data.category}"
        company.text = data.company
        title.text = data.ad_name
        view_count.text = count
        like_count.text = like

        itemView.setOnClickListener {
            val intent = Intent(itemView.context,IndiviualActivity::class.java)
            intent.putExtra("company", data.company)
            intent.putExtra("title", data.ad_name)
            intent.putExtra("view_count",count)
            intent.putExtra("like_count",like)
            itemView.context.startActivity(intent)
        }
    }
}