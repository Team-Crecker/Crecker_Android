package org.techtown.crecker.mypage.report.fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_individual.view.*

import org.techtown.crecker.R
import org.techtown.crecker.module.RcvItemDeco
import org.techtown.crecker.module.debugLog
import org.techtown.crecker.mypage.report.adapter.IndividualRvAdp
import org.techtown.crecker.mypage.report.api.ReportServiceImpl
import org.techtown.crecker.mypage.report.data.IndividualData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        val call : Call<IndividualData> = ReportServiceImpl.service.getIndividual()
        call.enqueue(
            object : Callback<IndividualData>{
                override fun onFailure(call: Call<IndividualData>, t: Throwable) {
                    "${t}".debugLog("CallBackFailed")
                }

                override fun onResponse(
                    call: Call<IndividualData>,
                    response: Response<IndividualData>
                ) {
                    response?.takeIf { it.isSuccessful }
                        ?.body()
                        ?.takeIf { it.success == true }
                        ?.data
                        ?.let{
                            listAdp.data = it
                            "ok".debugLog()
                            listAdp.notifyDataSetChanged()
                        }
                }
            }
        )
    }

    companion object {

        @JvmStatic
        fun newInstance() = IndividualFragment()
    }
}
