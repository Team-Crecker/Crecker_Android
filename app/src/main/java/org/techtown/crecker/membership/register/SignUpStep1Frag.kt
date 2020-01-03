package org.techtown.crecker.membership.register

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up_step1.view.*
import org.techtown.crecker.R
import org.techtown.crecker.membership.SignUpData
import org.techtown.crecker.membership.SignUpData.email

class SignUpStep1Frag  : Fragment() {
    private lateinit var mContext : Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
        View? {
            val V = inflater.inflate(R.layout.fragment_sign_up_step1, container, false)
            mContext = V.context
            SignUpData.let {
                it.email = V.edt_register_step1_id.text.toString()
                it.password = V.edt_register_step1_pwd.text.toString()
                it.phone = V.edt_register_step1_phone.text.toString()
            }

            return V
    }


}