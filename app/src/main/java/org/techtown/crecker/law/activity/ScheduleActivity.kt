package org.techtown.crecker.law.activity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.michaldrabik.classicmaterialtimepicker.CmtpTimeDialogFragment
import com.michaldrabik.classicmaterialtimepicker.utilities.setOnTime24PickedListener
import kotlinx.android.synthetic.main.activity_schedule.*
import org.techtown.crecker.R
import org.techtown.crecker.module.KeyboardVisibilityUtils
import java.text.SimpleDateFormat
import java.util.*

class ScheduleActivity : AppCompatActivity() {
    private lateinit var mCurrentTime : Calendar
    private  var myCalendar = Calendar.getInstance()
    val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, month)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabel()
    }

    private  var sName : String = ""// 이름
    private  var sDate : String = ""// 날짜
    private  var sTime : String = ""// 시간
    private  var sContent : String = "" // 내용

    private lateinit var keyboardVisibilityUtils: KeyboardVisibilityUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

//        이름
        schedule_name_edit.setOnClickListener {
            sName = schedule_name_edit.text.toString()
        }

//        DatePickerDialog 사용
        schedule_date_edit.setOnClickListener {
            DatePickerDialog(
                this,
                R.style.CustomDialog,
                datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()

            sDate = schedule_date_edit.text.toString()
        }

//        TimePickerDialog 사용
        schedule_time_edit.setOnClickListener {
            mCurrentTime = Calendar.getInstance()

            val timePicker = CmtpTimeDialogFragment.newInstance("확인","취소")
            timePicker.setInitialTime24(12, 0)
            timePicker.setOnTime24PickedListener {
                mCurrentTime.set(Calendar.HOUR_OF_DAY, it.hour)
                mCurrentTime.set(Calendar.MINUTE, it.minute)
                updateTimeLabel()
            }

            timePicker.show(supportFragmentManager,"Tag")

            sTime = schedule_time_edit.text.toString()
        }

//        내용
        schedule_content_edit.setOnClickListener {
            sContent = schedule_content_edit.text.toString()
        }

//        뒤로가기
        schedule_back_img.setOnClickListener {
            finish()
        }



//        상담신청 완료버튼 (현재는 토스트 출력 후 종료)
        schedule_ok_btn.setOnClickListener {
            val pass : Boolean = checkingFill()
            if(pass == true)
                Toast.makeText(this,"상담 신청이 완료되었습니다.",Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this,"빈 칸없이 작성해주세요.",Toast.LENGTH_LONG).show()
        }

        keyboardVisibilityUtils = KeyboardVisibilityUtils(window,
            onShowKeyboard = { keyboardHeight ->
                sv_root.run {
                    smoothScrollTo(scrollX, scrollY + keyboardHeight)
                }
            })

    }

    //날짜 선택시 정해진 형식으로 출력하는 함수
    private fun updateLabel(){
        var format = "yyyy / MM / dd" // 출력 형식
        var changeFormat = SimpleDateFormat(format, Locale.KOREA)

        schedule_date_edit.setText(changeFormat.format(myCalendar.time))
    }

    //시간 선택시 정해진 형식으로 출력하는 함수
    private fun updateTimeLabel(){
        var format = "a hh : mm"
        var changeFormat = SimpleDateFormat(format, Locale.US)

        schedule_time_edit.setText(changeFormat.format(mCurrentTime.time))
    }

    private fun checkingFill() : Boolean{
        if (sName != null && sTime != null && sDate != null && sContent != null)  return true

        else return false
    }

    override fun onDestroy() {
        keyboardVisibilityUtils.detachKeyboardListeners()
        super.onDestroy()
    }


}


