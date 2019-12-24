package org.techtown.crecker.feature.ads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import org.techtown.crecker.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        dropdown.setOnClickListener { startActivity(Intent(this, CategoryActivity::class.java)) }
        tv_title.text = intent.getStringExtra("title")
    }
}
