package org.techtown.crecker.membership.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.amn.easysharedpreferences.EasySharedPreference
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.fragment_sign_up_step1.*
import kotlinx.android.synthetic.main.fragment_sign_up_step2.*
import kotlinx.android.synthetic.main.fragment_sign_up_step4.*
import org.techtown.crecker.R
import org.techtown.crecker.main.MainActivity
import org.techtown.crecker.membership.api.LoginServiceImpl
import org.techtown.crecker.membership.api.SignUpServiceImpl
import org.techtown.crecker.membership.data.LoginResultData
import org.techtown.crecker.membership.data.SignUpResultData
import org.techtown.crecker.membership.login.LogInActivity
import org.techtown.crecker.module.debugLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    val regUserInfoMap : HashMap<String, Any> = HashMap<String, Any>()
    lateinit var email : String
    lateinit var pw : String
    lateinit var phone: String
    lateinit var loc : String
    lateinit var name : String
    lateinit var chName : String
    lateinit var url : String
    lateinit var notRegUrl : String
    var agreement: Int = 0
    lateinit var interest : MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        var tmpStr = "first"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportFragmentManager.beginTransaction().add(R.id.fl_signup_container, SignUpStep1Frag()).commit()

        setOnClickListener()
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

        when(frag) {
            is SignUpStep1Frag -> {

                /*
                regUserInfoMap.put("email", email)
                regUserInfoMap.put("password",pw)
                regUserInfoMap.put("phone",phone)
                regUserInfoMap.put("location", loc)*/


                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
                btn_register_next.text = "다음"

            }
            is SignUpStep2Frag -> {
                /*
                regUserInfoMap.put("name", name)
                regUserInfoMap.put("channelName", chName)
                regUserInfoMap.put("youtubeUrl", url)
                regUserInfoMap.put("agreement", agreement)*/
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep4Frag()).commit()
                btn_register_next.text = "다음"
            }
           /* is SignUpStep3Frag -> {
                when(findViewById<RadioGroup>(R.id.rg_register_step3_ads).checkedRadioButtonId){
                     R.id.rb_register_step3_ads_beauty -> interest.add("0101")
                     R.id.rb_register_step3_ads_restu -> interest.add("0102")
                     R.id.rb_register_step3_ads_travel -> interest.add("0103")
                }

                when(findViewById<RadioGroup>(R.id.rg_register_step3_expert).checkedRadioButtonId){
                    R.id.rb_register_step3_expert_law -> interest.add("0201")
                    R.id.rb_register_step3_expert_brand -> interest.add("0202")
                    R.id.rb_register_step3_expert_shoot -> interest.add("0203")
                }

                when(findViewById<RadioGroup>(R.id.rg_register_step3_news).checkedRadioButtonId){
                    R.id.rb_register_step3_news_daily -> interest.add("0301")
                    R.id.rb_register_step3_new_support -> interest.add("0302")
                }

                regUserInfoMap.put("interest", interest)

                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep4Frag()).commit()
                btn_register_next.text = "인증하기"
            }*/
            is SignUpStep4Frag -> {

                regUserInfoMap.put("notRegisterUrl", notRegUrl)

                SignUpServiceImpl.service.getSignUpResult(regUserInfoMap).enqueue(object :
                    Callback<SignUpResultData> {
                    override fun onFailure(call: Call<SignUpResultData>, t: Throwable) {
                        //네트워크 통신에 실패했을 때
                        Log.e("cre__", "error : $t")
                    }

                    override fun onResponse(
                        call: Call<SignUpResultData>,
                        response: Response<SignUpResultData>
                    ) {
                        Log.d("cre__", "get user info success ${response.isSuccessful}")
                        //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                        if (response.isSuccessful) {
                            when (response.code()) {
                                200 -> {
                                    if(response.body()!!.success) {
                                        // EasySharedPreference.putString("token", response.body()!!.data.tokens.token)
                                        startActivity(Intent(this@SignUpActivity, LogInActivity::class.java))
                                    }
                                    else
                                        Toast.makeText(this@SignUpActivity, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                                }
                                405 -> Toast.makeText(this@SignUpActivity, "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show()
                                500 -> Toast.makeText(this@SignUpActivity, "회원가입 실패 : 서버 오류", Toast.LENGTH_LONG).show()
                            }

                        }
                    }
                })


                finish()
            }
        }
    }

    private fun changeFragmentBackBtn() {
        val frag = supportFragmentManager.findFragmentById(R.id.fl_signup_container) as Fragment

        when(frag) {
            is SignUpStep1Frag -> {
                btn_register_next.text = "신청하기"
                finish()
            }
            is SignUpStep2Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep1Frag()).commit()
                btn_register_next.text = "신청하기"
            }
            /*
            is SignUpStep3Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
                btn_register_next.text = "다음"
            }*/
            is SignUpStep4Frag -> {
                supportFragmentManager.beginTransaction().replace(R.id.fl_signup_container, SignUpStep2Frag()).commit()
                btn_register_next.text = "다음"
            }
        }
    }


}
