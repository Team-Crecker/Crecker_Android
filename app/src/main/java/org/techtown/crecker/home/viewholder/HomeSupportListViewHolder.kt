package org.techtown.crecker.home.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R
import org.techtown.crecker.home.data.HomeSupportListData
import org.techtown.crecker.news.activity.NewsMoreActivity

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

        itemView.setOnClickListener{
            it.context.startActivity(
                Intent(it.context, NewsMoreActivity::class.java)
                    .apply {
                        this.putExtra("Idx", data.newsIdx)
                    })
        }
    }
}