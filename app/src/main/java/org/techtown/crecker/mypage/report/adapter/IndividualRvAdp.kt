package org.techtown.crecker.mypage.report.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.mypage.report.data.IndividualData
import org.techtown.crecker.mypage.report.viewholder.IndividualReportVH

class IndividualRvAdp (private val context: Context) : RecyclerView.Adapter<IndividualReportVH>(){
    var data = listOf<IndividualData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndividualReportVH {
        val view = LayoutInflater.from(context).inflate(R.layout.individual_list_item,
            parent, false)
        return IndividualReportVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: IndividualReportVH, position: Int){
        holder.onBind(data[position])
    }
}