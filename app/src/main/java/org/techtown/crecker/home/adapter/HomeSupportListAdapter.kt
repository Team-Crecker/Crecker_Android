package org.techtown.crecker.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.home.data.HomeSupportListData
import org.techtown.crecker.home.viewholder.HomeSupportListViewHolder

class HomeSupportListAdapter(
    private val context: Context
) : RecyclerView.Adapter<HomeSupportListViewHolder>() {

    var data: List<HomeSupportListData.Data> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSupportListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_support_item, parent, false)
        return HomeSupportListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeSupportListViewHolder, position: Int) {
        holder.onBind(data[position])
    }
}
