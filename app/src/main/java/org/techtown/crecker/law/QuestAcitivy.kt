package org.techtown.crecker.law

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quest.*
import org.techtown.crecker.R
import org.w3c.dom.Text
import kotlin.properties.Delegates

class QuestAcitivy : AppCompatActivity() {
    private lateinit var law : TextView
    private lateinit var start : TextView
    private lateinit var shooting : TextView

    // 카테고리 선택 기준 1 = Law , 2 = Start_up , 3 = Shooting
//    0일 경우에는 카테고리 선택하라는 토스트를 추가해준다.
    private var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        law = findViewById(R.id.ct_law_tv)
        start = findViewById(R.id.ct_start_tv)
        shooting = findViewById(R.id.ct_shooting_tv)

        law.setOnClickListener {
            check = changeBack(1)
        }

        start.setOnClickListener {
            check = changeBack(2)
        }

        shooting.setOnClickListener {
            check = changeBack(3)
        }

        question_cancle_img.setOnClickListener{
            finish()
        }
    }

    private fun changeBack(position : Int) : Int{
        when(position){
            1 ->{
                law.setBackgroundResource(R.drawable.btn_filled_category)
                law.setTextColor(Color.parseColor("#ffffff"))
                start.setBackgroundResource(R.drawable.btn_category)
                start.setTextColor(Color.parseColor("#000000"))
                shooting.setBackgroundResource(R.drawable.btn_category)
                shooting.setTextColor(Color.parseColor("#000000"))
                return 1
            }

            2 -> {
                law.setBackgroundResource(R.drawable.btn_category)
                law.setTextColor(Color.parseColor("#000000"))
                start.setBackgroundResource(R.drawable.btn_filled_category)
                start.setTextColor(Color.parseColor("#ffffff"))
                shooting.setBackgroundResource(R.drawable.btn_category)
                shooting.setTextColor(Color.parseColor("#000000"))
                return 2
            }
            else->{
                law.setBackgroundResource(R.drawable.btn_category)
                law.setTextColor(Color.parseColor("#000000"))
                start.setBackgroundResource(R.drawable.btn_category)
                start.setTextColor(Color.parseColor("#000000"))
                shooting.setBackgroundResource(R.drawable.btn_filled_category)
                shooting.setTextColor(Color.parseColor("#ffffff"))
                return 3
            }
        }
    }
}
