package org.techtown.crecker.ads.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_category.*
import android.content.Intent
import android.app.Activity


class CategoryActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(org.techtown.crecker.R.layout.activity_category)

        init()
    }

    private fun init() {
        btn_quit.setOnClickListener {
            quit()
        }

        tv_beauty.setOnClickListener(this)
        tv_restau.setOnClickListener(this)
        tv_travel.setOnClickListener(this)
        tv_culture.setOnClickListener(this)
        tv_other.setOnClickListener(this)
    }

    private fun quit() {
        val i = Intent().apply {
            putExtra("title", intent.getStringExtra("oldTitle"))
                .putExtra("isShow", intent.getBooleanExtra("oldBool", false))
        }
        setResult(Activity.RESULT_OK, i)
        finish()
    }

    override fun onClick(v: View?) {
        val title = when(v?.id){
            org.techtown.crecker.R.id.tv_beauty -> "Beauty"
            org.techtown.crecker.R.id.tv_restau -> "Restaurant"
            org.techtown.crecker.R.id.tv_travel -> "Travel"
            org.techtown.crecker.R.id.tv_culture -> "Culture"
            org.techtown.crecker.R.id.tv_other -> "Other"
            else -> ""
        }
        EventBus.title = title
        val i = Intent().apply { putExtra("title", title).putExtra("isShow", true) }
        setResult(Activity.RESULT_OK, i)
        finish()
    }

    override fun onBackPressed() {
        val i = Intent().apply {
            putExtra("title", intent.getStringExtra("oldTitle"))
                .putExtra("isShow", intent.getBooleanExtra("oldBool", false))
        }
        setResult(Activity.RESULT_OK, i)
        finish()
    }
}