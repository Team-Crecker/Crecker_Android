package org.techtown.crecker.mypage.contents.myAd

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.mypage.advertise.data.TagAdData

class MyTagAdAdapter (private val context : Context, var data: ArrayList<TagAdData.Data>, val flag: Int) : RecyclerView.Adapter<MyTagAdsVH>(), Filterable{
    val backup = data
    lateinit var filtered: ArrayList<TagAdData.Data>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTagAdsVH {
        val view = LayoutInflater.from(context).inflate(R.layout.my_ad_item_list, parent , false)
        return MyTagAdsVH(view, flag)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyTagAdsVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getFilter()
            = object : Filter(){
        override fun performFiltering(p0: CharSequence?): FilterResults {
            val str = p0.toString()
            filtered = backup
            return FilterResults().apply { values = filtered }
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            data = p1?.values as ArrayList<TagAdData.Data>
            notifyDataSetChanged()
        }

    }
}