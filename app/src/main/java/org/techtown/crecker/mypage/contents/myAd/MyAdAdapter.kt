package org.techtown.crecker.mypage.contents.myAd

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.ads.contents.AdData

class MyAdAdapter (private val context : Context, var data: ArrayList<AdData>) : RecyclerView.Adapter<MyAdsVH>(), Filterable{
    val backup = data
    lateinit var filtered: ArrayList<AdData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdsVH {
        val view = LayoutInflater.from(context).inflate(R.layout.my_ad_item_list, parent , false)
        return MyAdsVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyAdsVH, position: Int) {
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
            data = p1?.values as ArrayList<AdData>
            notifyDataSetChanged()
        }

    }
}