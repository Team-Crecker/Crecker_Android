package org.techtown.crecker.feature.ads

import android.view.View
import com.zhpan.bannerview.holder.ViewHolder
import org.techtown.crecker.R


class NetViewHolder : ViewHolder<AdBean> {

    override fun getLayoutId(): Int = R.layout.banner_ads

    override fun onBind(itemView: View?, data: AdBean?, position: Int, size: Int) {

    }
}