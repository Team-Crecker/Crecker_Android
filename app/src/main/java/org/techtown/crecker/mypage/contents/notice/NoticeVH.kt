package org.techtown.crecker.mypage.contents.notice

import android.content.Intent
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.mypage.notice.NoticeDetailActivity


class NoticeVH(view : View) : RecyclerView.ViewHolder(view){
    private val btnGo : ImageButton = view.findViewById(R.id.notice_btn_go)
    private val tvTitle : TextView = view.findViewById(R.id.notice_title)
    private val tvDate : TextView = view.findViewById(R.id.notice_date)

    fun bind(data : NoticeData.Data) {
        tvTitle.text = data.title
        tvDate.text = data.createAt.substring(0, 10)

        btnGo.setOnClickListener {
            it.context.startActivity(
                Intent(it.context, NoticeDetailActivity::class.java).apply {
                    putExtra("idx", data.noticeIdx)
                })
        }
    }
}