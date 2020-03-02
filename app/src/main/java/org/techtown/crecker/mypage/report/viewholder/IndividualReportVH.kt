package org.techtown.crecker.mypage.report.viewholder

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.mypage.report.activity.IndiviualActivity
import org.techtown.crecker.mypage.report.data.IndividualData

class IndividualReportVH (view: View) : RecyclerView.ViewHolder(view){
    private val category : TextView = view.findViewById(R.id.indi_category_tv)
    private val company : TextView = view.findViewById(R.id.indi_company_tv)
    private val title : TextView = view.findViewById(R.id.indi_title_tv)
    private val view_count : TextView = view.findViewById(R.id.indi_count)
    private val like_count : TextView = view.findViewById(R.id.indi_like)

    fun onBind(data : IndividualData.Data){
//        company.text = data.companyName
        company.visibility = View.GONE
        title.text = data.title
        category.text = "#${data.categoryName}"
        view_count.text = data.views1.toString()
        like_count.text = data.likes.toString()

        itemView.setOnClickListener {
            val intent = Intent(itemView.context,IndiviualActivity::class.java)
            intent.putExtra("Idx", data.userAdIdx)
            itemView.context.startActivity(intent)
        }
    }
}