package org.techtown.crecker.mypage.setting

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.Spanned
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_select_ctg.*
import org.techtown.crecker.R

class SelectCtgActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_ctg)

        val span: Spannable = txt.text as Spannable
        span.setSpan(StyleSpan(Typeface.BOLD), 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}
