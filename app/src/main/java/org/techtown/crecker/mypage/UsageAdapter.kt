package org.techtown.crecker.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R

class UsageAdapter (private val context : Context, var data: ArrayList<UsageRecord>) : RecyclerView.Adapter<UsageVH>(), Filterable{
    val backup = data

    lateinit var filtered: ArrayList<UsageRecord>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsageVH {
        val view = LayoutInflater.from(context).inflate(R.layout.usage_item, parent , false)
        return UsageVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UsageVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getFilter()
    = object : Filter(){
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val str = p0.toString()

            filtered =
                if(str.isEmpty()) backup
                else{
                    val filtering = ArrayList<UsageRecord>()
                    for(i in backup){
                        if(i.io == str)
                            filtering.add(i)
                    }
                filtering
            }
            return FilterResults().apply { values = filtered }
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            data = p1?.values as ArrayList<UsageRecord>
            notifyDataSetChanged()
        }

    }
}