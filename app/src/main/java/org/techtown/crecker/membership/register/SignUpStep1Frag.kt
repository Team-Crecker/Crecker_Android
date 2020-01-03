package org.techtown.crecker.membership.register

import android.content.Context
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up_step1.view.*
import org.techtown.crecker.R
import org.techtown.crecker.membership.data.SignData

class SignUpStep1Frag  : Fragment() {
    private lateinit var mContext : Context
    private lateinit var mView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(R.layout.fragment_sign_up_step1, container, false)
        mContext = V.context
        mView = V
        V.edt_register_step1_phone.addTextChangedListener(
            PhoneNumberFormattingTextWatcher()
        )

            V.step_1_btn_register_next.setOnClickListener {
                if(checking()) {
                    SignData.let {
                        it.email = V.edt_register_step1_id.text.toString()
                        it.password = V.edt_register_step1_pwd.text.toString()
                        it.phone = V.edt_register_step1_phone.text.toString()
                        it.address = V.edt_register_step1_addr.text.toString()
                    }
                    var activity = activity as SignUpActivity
                    activity.changeFragment()
                }
                else{
                    Toast.makeText(mContext,"모든 항목을 작성해주세요.",Toast.LENGTH_LONG).show()
                }

            }

            return V
    }

    private fun checking() : Boolean {
        if (mView.edt_register_step1_id.text.toString() =="" ||
            mView.edt_register_step1_pwd.text.toString()==""||
            mView.edt_register_step1_phone.text.toString()==""||
            mView.edt_register_step1_addr.text.toString()=="") {

            return false
        }
        else{
            return true
        }

    }


}