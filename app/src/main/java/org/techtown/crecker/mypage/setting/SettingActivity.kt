package org.techtown.crecker.mypage.setting

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import gun0912.tedimagepicker.builder.TedImagePicker
import kotlinx.android.synthetic.main.activity_setting.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.techtown.crecker.module.putLog
import org.techtown.crecker.mypage.api.SettingServiceImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import okhttp3.RequestBody


class SettingActivity : AppCompatActivity() {

    lateinit var uri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(org.techtown.crecker.R.layout.activity_setting)

        btn_goBack.setOnClickListener { finish() }

        btn_img_upload.setOnClickListener{
            TedImagePicker.with(this)
                .start { uri -> showSingleImage(uri)  }
        }

        btn_go_interest.setOnClickListener {
            startActivity(Intent(this, SelectCtgActivity::class.java))
        }


        SettingServiceImpl.service.getProfileInfo().enqueue(object : Callback<ProfileInfo>{
            override fun onFailure(call: Call<ProfileInfo>, t: Throwable) {
                Toast.makeText(this@SettingActivity, "사용자 프로필을 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ProfileInfo>, response: Response<ProfileInfo>) {
                response.takeIf { it.isSuccessful }?.body()?.data!![0]
                    .let {
                        Glide.with(this@SettingActivity)
                            .load(it.profileImage)
                            .into(imgView_profile)

                        setting_et_p.setText(it.phone)
                        setting_et_addr.setText(it.location)
                    }
            }
        })

        setting_btn_change.setOnClickListener {
            val file = File(uri.path!!)
            //val fbody = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val phone = setting_et_p.text.toString()
            val location = setting_et_addr.text.toString()

            val map = HashMap<String, RequestBody>()
            map["\"profileImage\\\"; filename=\\\"pp.jpeg\\\"\""] = RequestBody.create("image/jpeg".toMediaTypeOrNull(), file)
            map["phone"] = RequestBody.create("text/plain".toMediaTypeOrNull(), phone)
            map["location"] = RequestBody.create("text/plain".toMediaTypeOrNull(), location)

            SettingServiceImpl.service.updateProfileInfo(map).enqueue(
                object : Callback<org.techtown.crecker.mypage.api.Response>{
                override fun onFailure(
                    call: Call<org.techtown.crecker.mypage.api.Response>,
                    t: Throwable
                ) {
                    "안됨".putLog()
                    Toast.makeText(this@SettingActivity, "실패", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<org.techtown.crecker.mypage.api.Response>,
                    response: Response<org.techtown.crecker.mypage.api.Response>
                ) {
                    "됨".putLog()
                    response.isSuccessful.toString().putLog()
                    response.takeIf { it.isSuccessful }?.body()?.message.let {
                        Toast.makeText(this@SettingActivity, it, Toast.LENGTH_SHORT).show()
                    }
                }

            })
        }
    }

    private fun showSingleImage(uri: Uri) {
        Glide.with(this).load(uri).into(imgView_profile)
        this.uri = uri
    }
}
