package org.techtown.crecker.home.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_support_item.view.*
import org.techtown.crecker.R
import org.techtown.crecker.home.data.HomeSupportItem

class HomeSupportListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val img :ImageView = view.findViewById(R.id.img_list_item_home_support)
    val company : TextView = view.findViewById(R.id.tv_list_item_home_support_company)
    val title : TextView = view.findViewById(R.id.tv_list_item_home_support_title)
    val date : TextView = view.findViewById(R.id.tv_list_item_home_support_date)

    fun onBind(data: HomeSupportItem) {
        company.text = data.company
        title.text = data.title
        date.text = data.date
    }
}