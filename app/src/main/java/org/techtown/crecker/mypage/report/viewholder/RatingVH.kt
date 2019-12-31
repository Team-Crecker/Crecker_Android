package org.techtown.crecker.mypage.report.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.techtown.crecker.R
import org.techtown.crecker.mypage.report.data.RatingData
import java.text.DecimalFormat

class RatingVH (view : View) : RecyclerView.ViewHolder(view){
    private val glideManager : RequestManager = Glide.with(itemView)
    private val formatter : DecimalFormat = DecimalFormat("###,###")

    val rate : TextView = view.findViewById(R.id.rating_num_tv)
    val categoryImage :ImageView = view.findViewById(R.id.rating_category_img)
    val rating_title : TextView = view.findViewById(R.id.rating_category_title_tv)
    val viewCount : TextView = view.findViewById(R.id.rating_view)

    public fun onBind (data : RatingData){
        rate.text = data.rate.toString()
        rating_title.text = data.title
        viewCount.text = formatter.format(data.viewCount)
    }

    private fun loading(url :String, view: ImageView){
        view.post{
            glideManager.load(url).into(view)
        }
    }

}