package org.techtown.crecker.law.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_answer.*
import org.techtown.crecker.R

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        answer_back_img.setOnClickListener{
            finish()
        }

        counseling_reserv_btn.setOnClickListener {
            Toast.makeText(this, "상담신청이 되었습니다.",Toast.LENGTH_LONG).show()
        }
    }
}
