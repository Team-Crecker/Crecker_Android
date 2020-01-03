package org.techtown.crecker.membership.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.amn.easysharedpreferences.EasySharedPreference
import kotlinx.android.synthetic.main.activity_log_in.*
import org.techtown.crecker.membership.register.SignUpActivity
import org.techtown.crecker.main.MainActivity
import org.techtown.crecker.membership.api.LoginServiceImpl
import org.techtown.crecker.membership.data.LoginResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.android.material.snackbar.Snackbar



class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(org.techtown.crecker.R.layout.activity_log_in)

        tv_login_signup.setOnClickListener{
            it.context.startActivity(Intent(it.context, SignUpActivity::class.java))
        }

        tv_login_checkout.setOnClickListener {  }

        initController()
    }

    private fun initController() {

        // 익명 클래스를 사용한 click 이벤트 구현
        tv_login_signup?.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(p0: View?) { // 파라미터는 클린 view의 참조 (https://developer.android.com/reference/android/view/View.OnClickListener)
                    // 회원가입 페이지로 이동해야 한다.
                    val intent = Intent(this@LogInActivity, SignUpActivity::class.java)

                    startActivity(intent)
                }
            }
        )

        // kotlin의 람다식을 사용한 click 이벤트 구현
        btn_login_login.setOnClickListener {
            // ID, PW 둘중 하나라도 공백이면 눌리지 않는다.
            val id = edt_login_id.text.toString()
            val pw = textInputEdt_login_pwd.text.toString()

            if (id.isEmpty() || pw.isEmpty()) {
                // 사용자에게 간단한 text 정보를 알려주기 위해 Toast를 띄워준다.
                Toast.makeText(this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 입력한 ID, 입력한 PW를 가지고 로그인 요청을 한다.
            val map : HashMap<String, Any> = HashMap<String, Any>()

            map["email"] = id
            map["password"] = pw

            LoginServiceImpl.service.getUser(map).enqueue(object :
                Callback<LoginResultData> {
                override fun onFailure(call: Call<LoginResultData>, t: Throwable) {
                    //네트워크 통신에 실패했을 때
                    Log.e("cre__", "error : $t")
                }

                override fun onResponse(
                    call: Call<LoginResultData>,
                    response: Response<LoginResultData>
                ) {
                    Log.d("cre__", "get user info success ${response.isSuccessful}")
                    //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                    if (response.isSuccessful) {
                        when (response.code()) {
                            200 -> {
                                if(response.body()!!.success) {
                                    EasySharedPreference.putString("token", response.body()!!.data.tokens.token)
                                    startActivity(Intent(this@LogInActivity, MainActivity::class.java))
                                }
                                else
                                    Toast.makeText(this@LogInActivity, "유효하지 않은 로그인입니다.", Toast.LENGTH_SHORT).show()
                            }
                            405 -> Toast.makeText(this@LogInActivity, "로그인 실패 : 아이디나 비번이 올바르지 않습니다", Toast.LENGTH_LONG).show()
                            500 -> Toast.makeText(this@LogInActivity, "로그인 실패 : 서버 오류", Toast.LENGTH_LONG).show()
                        }

                    }
                }
            })
        }
    }

    override fun onBackPressed() {
        Snackbar.make(findViewById(android.R.id.content), "종료하시겠습니까?", Snackbar.LENGTH_SHORT).setAction("예") { view ->
            finish()
            android.os.Process.killProcess(android.os.Process.myPid())
        }.show()
    }
}


