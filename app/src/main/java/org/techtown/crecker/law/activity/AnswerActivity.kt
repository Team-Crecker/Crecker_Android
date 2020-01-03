package org.techtown.crecker.law.activity

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.law_counseling_list_item.*
import org.techtown.crecker.R
import org.techtown.crecker.law.api.ExpertServiceImpl
import org.techtown.crecker.law.data.QAdetailData
import org.techtown.crecker.module.debugLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AnswerActivity : AppCompatActivity() {
    private var Idx : Int = 0
    private  var isComplete: Int = 1
    private lateinit var glideManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        glideManager  = Glide.with(this)
        Idx = intent.getIntExtra("Idx",1)
        isComplete = intent.getIntExtra("isComplete",1)
        val isUser = intent.getBooleanExtra("isUser",true)

        answer_back_img.setOnClickListener{
            finish()
        }

        if(isComplete == 0){
            counseling_reserv_btn.visibility = View.INVISIBLE
            answer_state_img.setImageResource(R.drawable.img_tag_gray_expert)
        }

        if(isUser == false){
            counseling_reserv_btn.visibility = View.GONE
        }

            startCommu()


        counseling_reserv_btn.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java)
            intent.putExtra("Idx",Idx)
            startActivity(intent)
        }
    }

    private fun startCommu() {

        val call: Call<QAdetailData> = ExpertServiceImpl.service.getLawDetail(Idx)
        call.enqueue(
            object : Callback<QAdetailData> {
                override fun onFailure(call: Call<QAdetailData>, t: Throwable) {
                    "${t}".debugLog("CallBackFailed")
                }

                override fun onResponse(
                    call: Call<QAdetailData>,
                    response: Response<QAdetailData>
                ) {
                    response?.takeIf { it.isSuccessful }
                        ?.body()
                        ?.takeIf { it.success == true }
                        ?.data
                        ?.let {
                                initView(it[0])
                        } ?: "null"
                }
            }
        )
    }


    private fun initProfile(url : String, view : ImageView){
        view.post{
            glideManager.load(url).into(view)
        }
    }

    private fun initView(data : QAdetailData.Data){
        answer_quest_title_tv.text = data.Qtitle
        answer_quest_content_tv.text = data.Qcontent
        answer_quest_data_tv.text = data.createAt
        answer_state_tv.text = data.categoryCode
        if(isComplete == 0){
            readyView()
        }
        else {
            a_betelang_name_tv.text = data.name
            a_betelang_answer_tv.text = data.Acontent
            a_betelang_answer_date_tv.text = data.answerUpdateAt
            a_betelang_affiliation_tv.text = data.description
            initProfile(data.photo, betelang_profile_image)
        }
    }
    private fun readyView(){
        a_betelang_class_tv.visibility = View.INVISIBLE
    }
}
