package org.techtown.crecker.law.viewholder

import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.techtown.crecker.R
import org.techtown.crecker.law.activity.AnswerActivity
import org.techtown.crecker.law.data.ExpertLawListData

class ExpertLawListVH(view : View) : RecyclerView.ViewHolder(view){
    val stateImage : ImageView = view.findViewById(R.id.law_counseling_state_img)
    val stateTitle : TextView = view.findViewById(R.id.law_counseling_state_tv)
    val lockImage : ImageView = view.findViewById(R.id.law_counseling_lock_img)
    val title : TextView = view.findViewById(R.id.law_counseling_title_tv)
    val content : TextView = view.findViewById(R.id.law_counseling_content_tv)

    fun onBind(data : ExpertLawListData, positon : Int){
        if (data.counseling_state == "답변완료") {
            Glide.with(itemView)
                .load(R.drawable.img_tag_green_expert)
                .into(stateImage)
        }
        else{
            Glide.with(itemView)
                .load(R.drawable.img_tag_gray_expert)
                .into(stateImage)
        }

        if (data.lock == true){
            content.setTextColor(Color.parseColor("#00ffffff"))
        }
        else{
            lockImage.visibility = View.GONE
        }
        stateTitle.text = data.counseling_state
        title.text = data.title
        content.text = data.content

        //클릭리스너 이벤트 구현
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, AnswerActivity::class.java)
            itemView.context.startActivity(intent)
        }

    }


}