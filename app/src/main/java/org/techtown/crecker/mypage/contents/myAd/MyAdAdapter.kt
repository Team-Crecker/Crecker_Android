package org.techtown.crecker.mypage.contents.myAd

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.mypage.advertise.data.UserAdData
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


class MyAdAdapter (private val context : Context, var data: ArrayList<UserAdData.Data>, val flag: Int) : RecyclerView.Adapter<MyAdsVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdsVH {
        val view = LayoutInflater.from(context).inflate(org.techtown.crecker.R.layout.my_ad_item_list, parent , false)
        return MyAdsVH(view, flag)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyAdsVH, position: Int) {
        holder.bind(data[position])
    }

    fun sort(filter: String){
        when(filter){
            "최신순" ->Collections.sort(data, sortByLatest)
            "마감순" ->Collections.sort(data, sortByDead)
        }
        notifyDataSetChanged()
    }

    private val sortByLatest =
        Comparator<UserAdData.Data> {
                object1, object2 ->
            object1.createAt.compareTo(object2.createAt)
        }

    private val sortByDead =
        Comparator<UserAdData.Data> {
                object1, object2 ->
            object1.uploadTo.compareTo(object2.uploadTo)
        }
}