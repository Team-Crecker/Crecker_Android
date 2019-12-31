package org.techtown.crecker.mypage.report.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.filtering_dialog_layout.*
import kotlinx.android.synthetic.main.fragment_individual.view.*

import org.techtown.crecker.R
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.mypage.report.adapter.IndividualRvAdp
import org.techtown.crecker.mypage.report.data.IndividualReportData


class IndividualFragment : Fragment() {

    private lateinit var listAdp : IndividualRvAdp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_individual, container, false)
        mountingRv(v, v.context)
        return v
    }

    private fun mountingRv(v : View, context : Context){
        listAdp = IndividualRvAdp(context)
        v.individual_rv.let{
            it.adapter = listAdp
            it.layoutManager = LinearLayoutManager(context)
            it.addItemDecoration(RcvItemDeco(context))
        }

        listAdp.data = arrayListOf(
            IndividualReportData(
                category = "Beauty",
                company = "Sol Theraphy",
                ad_name = "시카솔 클렌징 워터",
                view_count = 200000,
                like_count = 3000
            ),
            IndividualReportData(
                category = "Beauty",
                company = "Sol Theraphy",
                ad_name = "시카솔 클렌징 워터",
                view_count = 200000,
                like_count = 3000
            ),
            IndividualReportData(
                category = "Beauty",
                company = "Sol Theraphy",
                ad_name = "시카솔 클렌징 워터",
                view_count = 200000,
                like_count = 3000
            )
        )
        listAdp.notifyDataSetChanged()
    }


    companion object {

        @JvmStatic
        fun newInstance() = IndividualFragment()
    }
}
