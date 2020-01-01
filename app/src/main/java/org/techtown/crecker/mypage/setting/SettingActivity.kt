package org.techtown.crecker.mypage.setting

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.builder.TedImagePicker
import kotlinx.android.synthetic.main.activity_setting.*
import org.techtown.crecker.R

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        btn_goBack.setOnClickListener { finish() }

        btn_img_upload.setOnClickListener{
            TedImagePicker.with(this)
                .start { uri -> showSingleImage(uri)  }
        }

        btn_go_interest.setOnClickListener {
            startActivity(Intent(this, SelectCtgActivity::class.java))
        }
    }

    private fun showSingleImage(uri: Uri) {
        Glide.with(this).load(uri).into(imgView_profile)
    }
}
