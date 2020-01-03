package org.techtown.crecker.mypage.scrap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.amn.easysharedpreferences.EasySharedPreference
import kotlinx.android.synthetic.main.activity_scrap.*
import org.techtown.crecker.R
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.TokenObject
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.mypage.scrap.adapter.ScrapAdp
import org.techtown.crecker.mypage.scrap.api.ScrapServiceImpl
import org.techtown.crecker.mypage.scrap.data.ScrapApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScrapActivity : AppCompatActivity() {
    private lateinit var sAdapter : ScrapAdp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrap)

        scrap_back_img.setOnClickListener {
            finish()
        }

        initRcv()
    }

    private fun initRcv(){
        sAdapter = ScrapAdp(this)
        scrap_rcv.let {
            it.adapter = sAdapter
            it.layoutManager = LinearLayoutManager(this)
            it.addItemDecoration(RcvItemDeco(this))
        }
        val call = ScrapServiceImpl.service.getTotalScrap()
        call.enqueue(
            object : Callback<ScrapApiData>{
                override fun onFailure(call: Call<ScrapApiData>, t: Throwable) {
                    "$t".debugLog("CallBackFailed in Scrrap")
                }

                override fun onResponse(
                    call: Call<ScrapApiData>,
                    response: Response<ScrapApiData>
                ) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.data
                        ?.let {
                            sAdapter.data = it
                            sAdapter.notifyDataSetChanged()
                        }
                }
            }
        )
    }
}
