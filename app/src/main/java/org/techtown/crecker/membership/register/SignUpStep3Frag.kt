package org.techtown.crecker.membership.register

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.*
import org.techtown.crecker.R
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_sign_up_step3.*
import kotlinx.android.synthetic.main.fragment_sign_up_step3.view.rg_register_step3_ads
import kotlinx.android.synthetic.main.rectangle.*


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
                    rb_register_step3_ads_culture.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_etc.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_restu  -> {
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_restu.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_culture.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_etc.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_travel  -> {
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_travel.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_culture.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_etc.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_culture  -> {
                    rb_register_step3_ads_culture.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_culture.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_etc.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_ads_etc  -> {
                    rb_register_step3_ads_etc.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_ads_etc.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_ads_travel.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_beauty.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_restu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_ads_culture.setTextColor(Color.parseColor("#000000"))
                }


            }
        }

        v.rg_register_step3_expert.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){

                R.id.rb_register_step3_expert_law  -> {
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_law.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_found.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_expert_found  -> {
                    rb_register_step3_expert_found.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_found.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_expert_shoot  -> {
                    rb_register_step3_expert_shoot.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_expert_shoot.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_expert_found.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_expert_law.setTextColor(Color.parseColor("#000000"))
                }

            }
        }

        v.rg_register_step3_support.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){

                R.id.rb_register_step3_support_edu  -> {
                    rb_register_step3_support_edu.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_support_edu.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_support_fund.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_support_contest.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_support_fund  -> {
                    rb_register_step3_support_fund.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_support_fund.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_support_edu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_support_contest.setTextColor(Color.parseColor("#000000"))
                }

                R.id.rb_register_step3_support_contest  -> {
                    rb_register_step3_support_contest.setTextColor(Color.parseColor("#f7f8f9"))
                    rb_register_step3_support_contest.setTypeface(Typeface.DEFAULT_BOLD)
                    rb_register_step3_support_edu.setTextColor(Color.parseColor("#000000"))
                    rb_register_step3_support_fund.setTextColor(Color.parseColor("#000000"))
                }

            }
        }


    }

}