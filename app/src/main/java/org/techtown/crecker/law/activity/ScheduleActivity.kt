package org.techtown.crecker.law.activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import com.michaldrabik.classicmaterialtimepicker.CmtpTimeDialogFragment
import com.michaldrabik.classicmaterialtimepicker.model.CmtpTime12
import com.michaldrabik.classicmaterialtimepicker.utilities.setOnTime12PickedListener
import com.michaldrabik.classicmaterialtimepicker.utilities.setOnTime24PickedListener
import kotlinx.android.synthetic.main.activity_schedule.*
import org.techtown.crecker.R
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.hours

class ScheduleActivity : AppCompatActivity() {
    private lateinit var mCurrentTime : Calendar
    private  var myCalendar = Calendar.getInstance()
    val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, month)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

//        DatePickerDialog 사용
        schedule_data_edit.setOnClickListener {
            DatePickerDialog(
                this,
                R.style.CustomDialog,
                datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
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
        }

//        뒤로가기
        schedule_back_img.setOnClickListener {
            finish()
        }

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE) // 키보드가 UI를 밀고올리는 현상 방지
    }

    //날짜 선택시 정해진 형식으로 출력하는 함수
    private fun updateLabel(){
        var format = "yyyy / MM / dd" // 출력 형식
        var changeFormat = SimpleDateFormat(format, Locale.KOREA)

        schedule_data_edit.setText(changeFormat.format(myCalendar.time))
    }

    //시간 선택시 정해진 형식으로 출력하는 함수
    private fun updateTimeLabel(){
        var format = "a hh : mm"
        var changeFormat = SimpleDateFormat(format, Locale.US)

        schedule_time_edit.setText(changeFormat.format(mCurrentTime.time))
    }
}
