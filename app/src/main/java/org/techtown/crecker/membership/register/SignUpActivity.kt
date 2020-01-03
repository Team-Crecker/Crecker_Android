package org.techtown.crecker.membership.register


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up_step1.*
import org.techtown.crecker.R

class SignUpActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var tmpStr = "first"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportFragmentManager.beginTransaction().add(R.id.fl_signup_container, SignUpStep1Frag()).commit()

        setOnClickListener()
    }

    private fun setOnClickListener() {
//        step_1_btn_register_next.setOnClickListener{
//            changeFragment()
//        }
        img_register_back.setOnClickListener {
            changeFragmentBackBtn()
        }
    }

    fun changeFragment() {
        val frag = supportFragmentManager.findFragmentById(R.id.fl_signup_container) as Fragment

        when(frag) {
            is SignUpStep1Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
            }
            is SignUpStep2Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep3Frag()).commit()
            }
            is SignUpStep3Frag->{
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep4Frag()).commit()
            }
            is SignUpStep4Frag -> {
                finish()
            }
        }
    }

    private fun changeFragmentBackBtn() {
        val frag = supportFragmentManager.findFragmentById(R.id.fl_signup_container) as Fragment

        when(frag) {
            is SignUpStep1Frag -> {
                step_1_btn_register_next.text = "신청하기"
                finish()
            }
            is SignUpStep2Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep1Frag()).commit()
                step_1_btn_register_next.text = "신청하기"
            }

            is SignUpStep3Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
            }
            is SignUpStep4Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
                step_1_btn_register_next.text = "다음"
            }
        }
    }


}
