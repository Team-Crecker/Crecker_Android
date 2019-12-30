package org.techtown.crecker.mypage.advertise.fragment

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.filtering_my_ad_dialog.*
import kotlinx.android.synthetic.main.fragment_my_ad_assign.view.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.contents.AdData
import org.techtown.crecker.module.NavBarSetting
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.mypage.contents.myAd.MyAdAdapter

class AssignFragment : Fragment() {
    lateinit var adapter: MyAdAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_my_ad_assign, container, false)

        v.ad_apply_filter.setOnClickListener { showFilter(v) }

        val dummy = AdData("", R.drawable.img_thum2, "모모스 커피", "Momos Coffee",10000, 7)
        val dummy2 = AdData("", R.drawable.img_thum_1, "시카솔 클렌징 워터", "Sol Theraphy",10000, 24)
        val dummy3 = AdData("", R.drawable.img_thum1, "데저트 크림", "Desert Cream",8000, 30)

        val data = arrayListOf(dummy, dummy2, dummy3, dummy)
        adapter = MyAdAdapter(v.context, data)

        v.rv_ad_apply_list.apply {
            this.adapter = this@AssignFragment.adapter
            layoutManager = LinearLayoutManager(v.context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(RcvItemDeco(v.context, false, 20))
        }
        return v
    }

    private fun showFilter(v: View) {
        val dialog = BottomSheetDialog(v.context)
            .apply {
                setContentView(R.layout.filtering_my_ad_dialog)
                category_latest.setOnClickListener {
                    adapter.filter.filter("")
                    v.textView39.text = "최신순"
                    dismiss()
                }
                category_dead.setOnClickListener {
                    adapter.filter.filter("")
                    v.textView39.text = "마감순"
                    dismiss()
                }

                when(v.textView39.text.toString()){
                    "최신순" -> {
                        category_latest.typeface = Typeface.DEFAULT_BOLD
                        category_dead.typeface = Typeface.DEFAULT
                    }
                    "마감순" -> {
                        category_latest.typeface = Typeface.DEFAULT
                        category_dead.typeface = Typeface.DEFAULT_BOLD
                    }
                }
            }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1)
            NavBarSetting.setWhite(dialog)
        dialog.show()
    }
}