package org.techtown.crecker.membership.register

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.*
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.rb_register_step3_ads_beauty
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.rb_register_step3_ads_restu
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.rb_register_step3_ads_travel
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.rb_register_step3_expert_law

import org.techtown.crecker.R
import org.techtown.crecker.membership.data.SignData


class SignUpStep3Frag : Fragment() {
    private lateinit var mView : View
    private  var interesting = listOf<String>()
    private lateinit var adInterest :String
    private lateinit var expertInterest : String
    private lateinit var newsInterest : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_sign_up_step3, container
            , false)
        mView = v
        initRadio(mView)
        v.step_3_btn_register_next.setOnClickListener {
            checking()
        }


        return v
    }

    private fun initRadio(v : View){
        v.rg_register_step3_ads.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.rb_register_step3_ads_beauty -> {
                    v.rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#ffffff"))
                    v.rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    v.rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                    adInterest = "0101"
                }

                R.id.rb_register_step3_ads_restu -> {
                    v.rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    v.rb_register_step3_ads_restu.setTextColor(Color.parseColor("#ffffff"))
                    v.rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                    adInterest = "0102"
                }
                R.id.rb_register_step3_ads_travel ->{
                    v.rb_register_step3_ads_beauty.setTextColor(Color.parseColor("000000"))
                    v.rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    v.rb_register_step3_ads_travel.setTextColor(Color.parseColor("#ffffff"))
                    adInterest = "0103"
                }
            }
            }

        v.rg_register_step3_expert.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.rb_register_step3_expert_law -> {
                    v.rb_register_step3_expert_law.setTextColor(Color.parseColor("#ffffff"))
                    v.rb_register_step3_expert_brand.setTextColor(Color.parseColor("#000000"))
                    val button : RadioButton = v.findViewById(R.id.rb_register_step3_expert_shooting)
                    button.setTextColor(Color.parseColor("#000000"))
                    expertInterest = "0201"
                }

                R.id.rb_register_step3_expert_brand -> {
                    v.rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                    v.rb_register_step3_expert_brand.setTextColor(Color.parseColor("#ffffff"))
                    val button : RadioButton = v.findViewById(R.id.rb_register_step3_expert_shooting)
                    button.setTextColor(Color.parseColor("#000000"))
                    expertInterest = "0202"
                }

                R.id.rb_register_step3_expert_shooting ->{
                    v.rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                    v.rb_register_step3_expert_brand.setTextColor(Color.parseColor("#000000"))
                    val button : RadioButton = v.findViewById(R.id.rb_register_step3_expert_shooting)
                    button.setTextColor(Color.parseColor("#ffffff"))
                    expertInterest = "0203"
                }
            }
        }

        v.rg_register_step3_news.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.rb_register_step3_new_support -> {
                    v.rb_register_step3_new_support.setTextColor(Color.parseColor("#ffffff"))
                    v.rb_register_step3_news_daily.setTextColor(Color.parseColor("#000000"))
                    newsInterest = "0301"
                }
                R.id.rb_register_step3_news_daily -> {
                    v.rb_register_step3_new_support.setTextColor(Color.parseColor("#000000"))
                    v.rb_register_step3_news_daily.setTextColor(Color.parseColor("#ffffff"))
                    newsInterest = "0302"
                }
            }
        }
    }
    private fun checking(){
        if(adInterest == "" || expertInterest == "" || newsInterest == ""){
            Toast.makeText(mView.context,"카테고리를 선택해 주세요.",
                Toast.LENGTH_LONG).show()
        }
        else{
            interesting = listOf(adInterest, expertInterest, newsInterest)
            SignData.let {
                it.interest = interesting
            }
            var activity = activity as SignUpActivity
            activity.changeFragment()
        }
    }
}
