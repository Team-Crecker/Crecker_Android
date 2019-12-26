package org.techtown.crecker.mypage

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import java.text.SimpleDateFormat


class UsageVH(view : View) : RecyclerView.ViewHolder(view){
    private val tvTitle : TextView = view.findViewById(R.id.usage_title)
    private val tvIO : TextView = view.findViewById(R.id.usage_io)
    private val tvMoney : TextView = view.findViewById(R.id.usage_money)
    private val tvDate : TextView = view.findViewById(R.id.usage_date)

    fun bind(data : UsageRecord) {
        tvTitle.text = data.title
        tvIO.text = data.io

        if(data.io == "입금"){
            tvMoney.text = "+${data.money}"
            tvMoney.setTextColor(itemView.context.resources.getColor(R.color.point))
        }
        else
            tvMoney.text = "-${data.money}"

        tvDate.text = SimpleDateFormat("yyyy.MM.dd").format(data.date)
    }
}