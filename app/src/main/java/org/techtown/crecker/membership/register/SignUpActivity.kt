package org.techtown.crecker.membership.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.techtown.crecker.R
import org.techtown.crecker.module.debugLog

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var tmpStr = "first"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        supportFragmentManager.beginTransaction().add(R.id.fl_signup_container, SignUpStep1Frag()).commit()
        setOnClickListener()

        initRegiserUser()
    }

    private fun initRegiserUser(){


    }

    private fun setOnClickListener() {
        btn_register_next.setOnClickListener{
            changeFragment()
        }
        img_register_back.setOnClickListener {
            changeFragmentBackBtn()
        }
    }

    private fun changeFragment() {
        val frag = supportFragmentManager.findFragmentById(R.id.fl_signup_container) as Fragment

        /*when(frag) {
            is SignUpStep1Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
                btn_register_next.text = "다음"
                "ok".debugLog()
            }
            is SignUpStep2Frag -> {
            supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep3Frag()).commit()
            btn_register_next.text = "다음"
        }
            is SignUpStep3Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep4Frag()).commit()
                btn_register_next.text = "인증하기"
            }
            is SignUpStep4Frag -> {
                finish()
            }
        }*/
    }

    private fun changeFragmentBackBtn() {
        val frag = supportFragmentManager.findFragmentById(R.id.fl_signup_container) as Fragment

        /*when(frag) {
            is SignUpStep1Frag -> {
                btn_register_next.text = "신청하기"
                finish()
            }
            is SignUpStep2Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep1Frag()).commit()
                btn_register_next.text = "신청하기"
            }
            is SignUpStep3Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
                btn_register_next.text = "다음"
            }
            is SignUpStep4Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep3Frag()).commit()
                btn_register_next.text = "다음"
            }
        }*/
    }

}
