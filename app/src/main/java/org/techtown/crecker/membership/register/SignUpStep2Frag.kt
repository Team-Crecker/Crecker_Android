package org.techtown.crecker.membership.register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up_step2.*
import kotlinx.android.synthetic.main.fragment_sign_up_step2.view.*
import org.techtown.crecker.R
import org.techtown.crecker.membership.data.SignData

class SignUpStep2Frag  : Fragment() {
    private lateinit var mContext : Context
    private lateinit var mView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        val V = inflater.inflate(R.layout.fragment_sign_up_step2, container, false)
        mContext = V.context
        mView = V

        checkboxStatus(V)
        activateCheckBoxListener(V)
        V.step_2_btn_register_next2.setOnClickListener {
            if (checking()) {
                SignData.let {
                    it.realName = edt_register_step2_name.text.toString()
                    it.youName = edt_register_step2_chname.text.toString()
                    it.youAddress = edt_register_step2_churl.text.toString()
                }

                var activity = activity as SignUpActivity
                activity.changeFragment()
            }
        }

        return V
    }

    private fun checking() : Boolean{
        if(mView.edt_register_step2_name.text.toString()=="" ||
                mView.edt_register_step2_chname.text.toString()==""||
                mView.edt_register_step2_churl.text.toString()==""){
            Toast.makeText(mContext,"모든 항목을 작성해주세요.",Toast.LENGTH_LONG).show()
            return false
        }
        else{
            if (mView.cb_register_step2_01.isChecked == false ||
                    mView.cb_register_step2_02.isChecked == false ||
                    mView.cb_register_step2_03.isChecked == false){
                Toast.makeText(mContext, "필수항목을 체크해주세요.",Toast.LENGTH_LONG).show()
                return false
            }
            else{
                return true
            }
        }
    }

    fun checkboxStatus(v : View) {
        if (v.cb_register_step2_01.isChecked && v.cb_register_step2_02.isChecked
            && v.cb_register_step2_03.isChecked) {

        } else {
            Toast.makeText(mContext, "필수 이용약관에 모두 동의해주세요", Toast.LENGTH_SHORT).show()
        }
    }

    fun activateCheckBoxListener(v: View) {
        v.img_register_step2_cb1_arrow.setOnClickListener{
            Toast.makeText(it.context, "이용약관 준비중입니다", Toast.LENGTH_SHORT).show()
        }
        v.img_register_step2_cb2_arrow.setOnClickListener{
            Toast.makeText(it.context, "이용약관 준비중입니다", Toast.LENGTH_SHORT).show()
        }
        v.img_register_step2_cb3_arrow.setOnClickListener{
            Toast.makeText(it.context, "이용약관 준비중입니다", Toast.LENGTH_SHORT).show()
        }
        v.img_register_step2_cb4_arrow.setOnClickListener{
            Toast.makeText(it.context, "이용약관 준비중입니다", Toast.LENGTH_SHORT).show()
        }
    }
}