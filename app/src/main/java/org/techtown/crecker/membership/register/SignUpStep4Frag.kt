package org.techtown.crecker.membership.register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up_step4.view.*
import org.techtown.crecker.R
import org.techtown.crecker.membership.data.SignData
import org.techtown.crecker.membership.api.SignUpServiceImpl
import org.techtown.crecker.membership.data.SignUpData
import org.techtown.crecker.membership.data.SignUpResultData
import org.techtown.crecker.module.debugLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpStep4Frag : Fragment() {
    private lateinit var mContext : Context
    private lateinit var mView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        val V = inflater.inflate(R.layout.fragment_sign_up_step4, container, false)
        mContext = V.context
        mView = V

        V.step_4_btn_register_next2.setOnClickListener {
            if(V.edt_register_step4_notRegUrl.text.toString() == ""){
                Toast.makeText(mContext,"URL을 입력해 주세요.",Toast.LENGTH_LONG).show()
            }
            else{
                SignData.let {
                    it.notRegUrl = V.edt_register_step4_notRegUrl.text.toString()
                    startCommu()

                }
            }
        }

        return V
    }

    private fun startCommu(){
        val call = SignUpServiceImpl.service.postSignUpResult(
            SignUpData(
                0, SignData.youName, SignData.email, SignData.interest,
                SignData.address, SignData.realName, SignData.notRegUrl,
                SignData.password, SignData.phone, SignData.youAddress
            ))
        call.enqueue(
            object : Callback<SignUpResultData>{
                override fun onFailure(call: Call<SignUpResultData>, t: Throwable) {
                    "${t}".debugLog("nononono")
                }

                override fun onResponse(
                    call: Call<SignUpResultData>,
                    response: Response<SignUpResultData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.let{
                            Toast.makeText(mView.context, "가입이 완료되었습니다.",
                                Toast.LENGTH_LONG).show()
                            var activity = activity as SignUpActivity
                            activity.changeFragment()
                        }

                }
            }
        )
    }
}