package org.techtown.crecker.membership.register

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.*
import org.techtown.crecker.R
import kotlinx.android.synthetic.main.fragment_sign_up_step3.*
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.rg_register_step3_ads


class SignUpStep3Frag : Fragment() {
    private lateinit var mContext : Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val V = inflater.inflate(org.techtown.crecker.R.layout.fragment_sign_up_step3, container, false)
        mContext = V.context

        radioGroupChangeLogic(V)

        return V
    }


    private fun radioGroupChangeLogic(v:View) {
        v.rg_register_step3_ads.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){

                R.id.rb_register_step3_ads_beauty  -> {
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_beauty.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_restu  -> {
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_restu.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_travel  -> {
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_travel.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                }


            }
        }

        v.rg_register_step3_expert.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){

                R.id.rb_register_step3_expert_law  -> {
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_law.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_brand.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_expert_brand  -> {
                    rb_register_step3_expert_brand.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_brand.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_expert_shoot  -> {
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_shoot.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_brand.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                }

            }
        }

        v.rg_register_step3_news.setOnCheckedChangeListener{ group, checkedId ->
            when(checkedId){

                R.id.rb_register_step3_news_daily  -> {
                    rb_register_step3_news_daily.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_news_daily.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_new_support.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_new_support  -> {
                    rb_register_step3_new_support.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_new_support.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_news_daily.setTextColor(Color.parseColor("#000000"))
                }

            }
        }


    }

}