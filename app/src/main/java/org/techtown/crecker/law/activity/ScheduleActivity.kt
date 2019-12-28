package org.techtown.crecker.law.activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_schedule.*
import org.techtown.crecker.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        editText2.setOnClickListener {
            DatePickerDialog(this,R.style.CustomDialog, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        editText.setOnClickListener {
            mCurrentTime = Calendar.getInstance()
            var hour = mCurrentTime.get(Calendar.HOUR_OF_DAY) // 현재 시
            var minute = mCurrentTime.get(Calendar.MINUTE) // 현재 분

            var mTimePiker = TimePickerDialog(this,android.R.style.Theme_DeviceDefault_Dialog_Alert,TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                editText.setText("${hourOfDay} : ${minute}")
            }, hour, minute, false)
            mTimePiker.setTitle("상담 시간")
            mTimePiker.show()
        }
    }

    private fun updateLabel(){
        var format = "yyyy / MM / dd" // 출력 형식
        var changeFormat = SimpleDateFormat(format, Locale.KOREA)

        editText2.setText(changeFormat.format(myCalendar.time))
    }
}
