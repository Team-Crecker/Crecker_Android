package org.techtown.crecker.law.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quest.*
import org.techtown.crecker.R
import org.techtown.crecker.module.KeyboardVisibilityUtils
import org.w3c.dom.Text
import kotlin.properties.Delegates

class QuestAcitivy : AppCompatActivity() {
    private lateinit var law : RadioButton
    private lateinit var start : RadioButton
    private lateinit var shooting : RadioButton
    private lateinit var category : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        law = findViewById(R.id.ct_law_tv)
        start = findViewById(R.id.ct_start_tv)
        shooting = findViewById(R.id.ct_shooting_tv)

        question_cancle_img.setOnClickListener{
            finish()
        }

        ct_radio_group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.ct_law_tv -> {
                    law.setBackgroundResource(R.drawable.btn_filled_category)
                    law.setTextColor(Color.parseColor("#ffffff"))
                    start.setBackgroundResource(R.drawable.btn_category)
                    start.setTextColor(Color.parseColor("#000000"))
                    shooting.setBackgroundResource(R.drawable.btn_category)
                    shooting.setTextColor(Color.parseColor("#000000"))
                    category = ct_law_tv.text.toString()
                }

                R.id.ct_start_tv -> {
                    law.setBackgroundResource(R.drawable.btn_category)
                    law.setTextColor(Color.parseColor("#000000"))
                    start.setBackgroundResource(R.drawable.btn_filled_category)
                    start.setTextColor(Color.parseColor("#ffffff"))
                    shooting.setBackgroundResource(R.drawable.btn_category)
                    shooting.setTextColor(Color.parseColor("#000000"))
                    category = ct_start_tv.text.toString()

                }

                R.id.ct_shooting_tv ->{
                    law.setBackgroundResource(R.drawable.btn_category)
                    law.setTextColor(Color.parseColor("#000000"))
                    start.setBackgroundResource(R.drawable.btn_category)
                    start.setTextColor(Color.parseColor("#000000"))
                    shooting.setBackgroundResource(R.drawable.btn_filled_category)
                    shooting.setTextColor(Color.parseColor("#ffffff"))
                    category = ct_shooting_tv.text.toString()


                }

            }
        }

        quest_ok_tv.setOnClickListener { checkingResult() }

        quest_content_tv.setHorizontallyScrolling(false) // 본문 컨텐츠 가로 스크롤 방지
    }
    private fun checkingResult(){
        if (check_secret.isChecked == false)
            Toast.makeText(this, "${category} + 공개글", Toast.LENGTH_LONG).show()
        else{
            Toast.makeText(this, "${category} + 비밀글", Toast.LENGTH_LONG).show()
        }
    }
}
