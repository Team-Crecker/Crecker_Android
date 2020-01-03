package org.techtown.crecker.mypage.contents.myAd

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.mypage.advertise.data.TagAdData
import org.techtown.crecker.mypage.advertise.data.UserAdData
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class MyTagAdAdapter (private val context : Context, var data: ArrayList<TagAdData.Data>, val flag: Int) : RecyclerView.Adapter<MyTagAdsVH>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyTagAdsVH {
        val view = LayoutInflater.from(context).inflate(R.layout.my_ad_item_list, parent , false)
        return MyTagAdsVH(view, flag)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyTagAdsVH, position: Int) {
        holder.bind(data[position])
    }

    fun sort(flag: String){
        when(flag){
            "최신순" -> Collections.sort(data, sortByLatest)
            "마감순" -> Collections.sort(data, sortByDead)
        }
        notifyDataSetChanged()
    }

    private val sortByLatest =
        Comparator<TagAdData.Data> {
                object1, object2 ->
            object1.createAt.compareTo(object2.createAt)
        }

    private val sortByDead =
        Comparator<TagAdData.Data> {
                object1, object2 ->
            object1.uploadTo.compareTo(object2.uploadTo)
        }
}