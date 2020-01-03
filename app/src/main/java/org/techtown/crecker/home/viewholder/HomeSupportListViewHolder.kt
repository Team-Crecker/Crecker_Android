package org.techtown.crecker.home.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.gson.JsonParser.parseString
import kotlinx.android.synthetic.main.home_support_item.view.*
import org.techtown.crecker.R
import org.techtown.crecker.home.data.HomeSupportItem
import org.techtown.crecker.home.data.HomeSupportListData

class HomeSupportListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val img :ImageView = view.findViewById(R.id.img_list_item_home_support)
    val company : TextView = view.findViewById(R.id.tv_list_item_home_support_company)
    val title : TextView = view.findViewById(R.id.tv_list_item_home_support_title)
    val date : TextView = view.findViewById(R.id.tv_list_item_home_support_date)

    fun onBind(data: HomeSupportListData.Data) {
        Glide.with(itemView)
            .load(data.poster)
            .into(img)
        company.text = data.host
        title.text = data.title
        date.text =  "D" + data.dday
    }
}