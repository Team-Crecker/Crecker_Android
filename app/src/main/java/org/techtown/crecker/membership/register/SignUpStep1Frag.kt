package org.techtown.crecker.membership.register

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.techtown.crecker.R

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

            return V
    }
}