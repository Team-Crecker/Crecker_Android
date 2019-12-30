package org.techtown.crecker.mypage.report

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_report.*
import org.techtown.crecker.R
import org.techtown.crecker.mypage.report.adapter.ReportVpAdapter

class ReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        mountingViewPager()
    }

    private fun mountingViewPager(){
        report_Vp.adapter = ReportVpAdapter(supportFragmentManager)
        mountingTabLayout()
    }

    private fun mountingTabLayout(){
        report_tab.setupWithViewPager(report_Vp)
        report_tab?.let {
            it.getTabAt(0)?.setText("토탈 리포트")
            it.getTabAt(1)?.setText("개별 리포트")
        }
    }
}
