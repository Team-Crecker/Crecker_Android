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
import androidx.fragment.app.Fragment
import com.squareup.otto.Subscribe
import kotlinx.android.synthetic.main.fragment_ads.view.*
import org.techtown.crecker.R
import org.techtown.crecker.ads.CategoryActivity
import org.techtown.crecker.ads.event.CtgResultEvent
import org.techtown.crecker.ads.event.FragmentCommunicator
import org.techtown.crecker.main.MainActivity

class AdsFragment : Fragment() {
    private lateinit var mContext: Context
    private lateinit var goDropDown: ImageView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ads, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        goDropDown = view.findViewById(R.id.dropdown)
        goDropDown.setOnClickListener {
            activity?.startActivityForResult(Intent(mContext, CategoryActivity::class.java), 7777)
        }

        (activity as MainActivity).passVal(object : FragmentCommunicator{
            override fun changeText(str: String?) {
                view.tv_title.text = str
            }
        })

        childFragmentManager.beginTransaction().add(R.id.frame_container, AdsMainFragment()).commit()
    }

    private fun changeFragment(fragment: Fragment){
        this.childFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

    /*private fun changeTitle(title: String){
        this.view?.findViewById<TextView>(R.id.tv_title)?.text = title
        fragmentManager!!.beginTransaction().detach(this).attach(this).commit()
    }*/

    @Subscribe
    fun onActivityResultEvent(event: CtgResultEvent) {
        onActivityResult(event.requestCode, event.resultCode, event.data)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        "나도 받음".putLog()
        if(requestCode == 7777){
            if(resultCode == Activity.RESULT_OK){
                changeFragment(AdsCtgFragment(data?.getStringExtra("title")))
            }
        }
    }
}
fun String.putLog(tag: String = "debugResult"){
    Log.d(tag, this)
}
