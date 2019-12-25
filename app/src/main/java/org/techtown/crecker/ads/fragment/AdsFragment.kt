package org.techtown.crecker.ads.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.squareup.otto.Subscribe
import kotlinx.android.synthetic.main.fragment_ads.view.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.category.CategoryActivity
import org.techtown.crecker.ads.category.CtgResultEvent
import org.techtown.crecker.ads.category.EventBus
import org.techtown.crecker.ads.category.FragmentCommunicator
import org.techtown.crecker.main.MainActivity

class AdsFragment : Fragment() {
    private lateinit var mContext: Context
    private lateinit var goDropDown: ImageView
    private lateinit var  tvTitle: TextView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ads, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EventBus.register(this)
    }

    override fun onDestroyView() {
        EventBus.unregister(this)
        super.onDestroyView()
    }

    private fun initView(view: View) {
        tvTitle = view.findViewById(R.id.tv_title)
        tvTitle.text = EventBus.title

        goDropDown = view.findViewById(R.id.dropdown)
        goDropDown.setOnClickListener {
            activity?.startActivityForResult(Intent(mContext, CategoryActivity::class.java)
                .apply {
                        putExtra("oldTitle", tvTitle.text.toString())
                        .putExtra("oldBool", view.goBack.isVisible)
                }, 7777)
        }

        (activity as MainActivity).passVal(object : FragmentCommunicator{
            override fun showBack(isShow: Boolean?) {
                view.goBack.isVisible = isShow!!
                if(!isShow) changeText("Advertise")
            }

            override fun changeText(str: String?) {
                tvTitle.text = str
            }
        })

        if(EventBus.isCtgSelected){
            changeFragment(AdsCtgFragment())
            view.goBack.isVisible = true
        }
        else{
            changeFragment(AdsMainFragment())
            view.goBack.isVisible = false
        }

        view.goBack.setOnClickListener {
            EventBus.isCtgSelected = false
            view.goBack.isVisible = false
            changeFragment(AdsMainFragment())
            tvTitle.text = "Advertise"
        }
    }

    private fun changeFragment(fragment: Fragment){
        this.childFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

    @Subscribe
    fun onActivityResultEvent(event: CtgResultEvent) {
        onActivityResult(event.requestCode, event.resultCode, event.data)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        "나도 받음".putLog()
        if(requestCode == 7777){
            if(resultCode == Activity.RESULT_OK){
                changeFragment(AdsCtgFragment())
                EventBus.isCtgSelected = true
            }
        }
    }
}
fun String.putLog(tag: String = "debugResult"){
    Log.d(tag, this)
}
