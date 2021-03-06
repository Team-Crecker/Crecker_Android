package org.techtown.crecker.main

import android.animation.Animator
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash.*
import org.techtown.crecker.R
import org.techtown.crecker.membership.login.LogInActivity

class SplashActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val animationView = findViewById<LottieAnimationView>(R.id.splash_img)

        animationView.setAnimation("splash.json")
        animationView.playAnimation()
        startLoading()

    }

    private fun startLoading(){
        val handler = Handler()
        handler.postDelayed(Runnable {
            run {
                startActivity(Intent(application, LogInActivity::class.java))
                finish()
            }
        },2000)
    }

    override fun onBackPressed() {
    }
}
