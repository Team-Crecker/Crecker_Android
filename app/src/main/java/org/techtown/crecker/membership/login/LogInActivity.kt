package org.techtown.crecker.membership.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_log_in.*
import org.techtown.crecker.membership.register.SignUpActivity
import org.techtown.crecker.R
import org.techtown.crecker.main.MainActivity
import org.techtown.crecker.membership.api.LoginServiceImpl
import org.techtown.crecker.membership.data.LoginResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

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
        btn_login_login?.setOnClickListener {
            // ID, PW 둘중 하나라도 공백이면 눌리지 않는다.
            val id = edt_login_id?.text.toString()
            val pw = textInputEdt_login_pwd?.text.toString()

            if (id.isEmpty() || pw.isEmpty()) {
                // 사용자에게 간단한 text 정보를 알려주기 위해 Toast를 띄워준다.
                Toast.makeText(this, "아이디나 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 입력한 ID, 입력한 PW를 가지고 로그인 요청을 한다.
            val response = requestLogin(id, pw)
            if (response) {
                val intent = Intent(this, MainActivity::class.java)
                // 로그인에 성공한 아이디를 넘겨주자.
                intent.putExtra("login", id)

                startActivity(intent)
            }
            else {
                // 로그인이 실패했으면 Toast를 사용해 로그인이 실패했다고 알려주고 아이디 혹은 비밀번호를 다시 입력하게 포커스를 이동시켜주자.
                Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                edt_login_id?.requestFocus()
            }
        }
    }

    private fun requestLogin(id: String, pw: Any) {

        LoginServiceImpl.service.getUser(HashMap<String, Any>()).enqueue(object :
            Callback<LoginResultData> {
            override fun onFailure(call: Call<LoginResultData>, t: Throwable) {
                //네트워크 통신에 실패했을 때
                Log.e("crecker", "error : $t")
            }

            override fun onResponse(
                call: Call<LoginResultData>,
                response: Response<LoginResultData>
            ) {
                //네트워크 통신에 성공했을때, response 에 서버에서 받아온 데이터가 있을 것이다.
                if (response.isSuccessful) {
                    val currentUser =
                        response.body()!! // TODO 여기서 body 가 없다면, 어플리케이션이 죽을 것이다 어떻게 해야할까?

                }
            }
        })
    }
}


