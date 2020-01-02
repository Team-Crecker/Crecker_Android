package org.techtown.crecker.law.viewholder

import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.techtown.crecker.R
import org.techtown.crecker.law.activity.AnswerActivity
import org.techtown.crecker.law.data.QAdata

class ExpertLawListVH(view : View) : RecyclerView.ViewHolder(view) {
    val glideManager: RequestManager = Glide.with(itemView)

    val stateImage: ImageView = view.findViewById(R.id.law_counseling_state_img)
    val stateTitle: TextView = view.findViewById(R.id.law_counseling_state_tv)
    val lockImage: ImageView = view.findViewById(R.id.law_counseling_lock_img)
    val title: TextView = view.findViewById(R.id.law_counseling_title_tv)
    val content: TextView = view.findViewById(R.id.law_counseling_content_tv)

    fun onBind(data: QAdata.Data, positon: Int) {
        if (data.isSecret == 1) {
            content.text = data.Qcontent
            content.setTextColor(Color.parseColor("#00ffffff"))
        } else {
            lockImage.visibility = View.GONE
            content.text = data.Qcontent
        }

        title.text = data.Qtitle

        if (data.isComplete == 1) {
            stateTitle.text = "답변완료"
            loading(R.drawable.img_tag_green_expert, stateImage)

        } else {
            loading(R.drawable.img_tag_gray_expert, stateImage)
            stateTitle.text = "답변예정"
        }

        if (data.isSecret == 1) {
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "비밀 글 입니다.", Toast.LENGTH_LONG)
                    .show()
            }
        }
        else{
            itemView.setOnClickListener {
                val intent = Intent(itemView.context,AnswerActivity::class.java)
                intent.putExtra("Idx",data.expertConsultIdx)
                intent.putExtra("isComplete",data.isComplete)
                itemView.context.startActivity(intent)
            }
        }
    }
    private fun loading(url: Int, view: ImageView) {
        view.post {
            glideManager.load(url).into(view)
        }
    }
}