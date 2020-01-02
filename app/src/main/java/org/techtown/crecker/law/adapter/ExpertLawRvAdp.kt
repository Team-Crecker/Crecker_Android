package org.techtown.crecker.law.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.law.data.QAdata
import org.techtown.crecker.law.viewholder.ExpertLawListVH

class ExpertLawRvAdp (private  val context : Context) : RecyclerView.Adapter<ExpertLawListVH>(){
    var data = mutableListOf<QAdata.Data>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertLawListVH {
        val view = LayoutInflater.from(context).inflate(R.layout.law_counseling_list_item, parent, false)
        return ExpertLawListVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ExpertLawListVH, position: Int) {
        holder.onBind(data[position],position)
    }

}