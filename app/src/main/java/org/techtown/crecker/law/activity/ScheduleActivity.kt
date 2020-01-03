package org.techtown.crecker.law.activity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.amn.easysharedpreferences.EasySharedPreference
import com.michaldrabik.classicmaterialtimepicker.CmtpTimeDialogFragment
import com.michaldrabik.classicmaterialtimepicker.utilities.setOnTime24PickedListener
import kotlinx.android.synthetic.main.activity_schedule.*
import org.techtown.crecker.R
import org.techtown.crecker.law.api.ExpertServiceImpl
import org.techtown.crecker.law.data.CounselingData
import org.techtown.crecker.law.data.CounselingResult
import org.techtown.crecker.module.KeyboardVisibilityUtils
import org.techtown.crecker.module.TokenObject
import org.techtown.crecker.module.debugLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class ScheduleActivity : AppCompatActivity() {
    private lateinit var mCurrentTime : Calendar
    private  var myCalendar = Calendar.getInstance()
    val datePicker = DatePickerDialog.OnDateSetListener {_, year, month, dayOfMonth ->
        myCalendar.set(Calendar.YEAR, year)
        myCalendar.set(Calendar.MONTH, month)
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        updateLabel()
    }


    private  var Idx : Int = 0 // 통신에 필요한 Idx 값

    private lateinit var keyboardVisibilityUtils: KeyboardVisibilityUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        Idx = intent.getIntExtra("Idx",0)


//        이름
        schedule_name_edit.setOnClickListener {
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

//        내용
        schedule_content_edit.setOnClickListener {

        }

//        뒤로가기
        schedule_back_img.setOnClickListener {
            finish()
        }



//        상담신청 완료버튼
        schedule_ok_btn.setOnClickListener {

            if(schedule_name_edit.text.toString() == ""
                || schedule_date_edit.text.toString() == ""
                || schedule_time_edit.text.toString() == ""
                || schedule_content_edit.text.toString() == "") {

                Toast.makeText(this,"빈 칸없이 작성해주세요.",Toast.LENGTH_LONG).show()
            }
            else{
                parsingSchedule()
                Toast.makeText(this,"상담신청이 완료 되었습니다.",
                    Toast.LENGTH_LONG).show()
                finish()
            }

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


    override fun onDestroy() {
        keyboardVisibilityUtils.detachKeyboardListeners()
        super.onDestroy()
    }

    private fun parsingSchedule(){
        val call : Call<CounselingResult> = ExpertServiceImpl.service.putCounseling(
            CounselingData(schedule_name_edit.text.toString(),schedule_date_edit.text.toString()
                ,schedule_time_edit.text.toString(),Idx,schedule_content_edit.text.toString()))

        call.enqueue(
            object : Callback<CounselingResult>{
                override fun onFailure(call: Call<CounselingResult>, t: Throwable) {
                    "${t}".debugLog("CallBackFailed")
                }

                override fun onResponse(
                    call: Call<CounselingResult>,
                    response: Response<CounselingResult>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.takeIf { it.success == true }
                        ?.let{
                            "${it.message}".debugLog()
                        }
                }
            }
        )
    }


}


