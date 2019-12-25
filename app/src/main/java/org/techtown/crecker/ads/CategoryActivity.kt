package org.techtown.crecker.feature.ads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_category.*
import org.techtown.crecker.R

class CategoryActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        init()
    }

    private fun init() {
        btn_quit.setOnClickListener { finish() }

        tv_beauty.setOnClickListener(this)
        tv_restau.setOnClickListener(this)
        tv_travel.setOnClickListener(this)
        tv_culture.setOnClickListener(this)
        tv_other.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val title = when(v?.id){
            R.id.tv_beauty -> "Beauty"
            R.id.tv_restau -> "Restaurant"
            R.id.tv_travel -> "Travel"
            R.id.tv_culture -> "Culture"
            R.id.tv_other -> "Other"
            else -> ""
        }
        CategoryState.category = title
        finish()
    }
}
