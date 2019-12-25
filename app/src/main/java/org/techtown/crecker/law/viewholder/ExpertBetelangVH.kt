package org.techtown.crecker.law.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import org.techtown.crecker.R
import org.techtown.crecker.law.data.ExpertBetelangData


class ExpertBetelangVH(view : View) : RecyclerView.ViewHolder(view){

    val Profile : ImageView = view.findViewById(R.id.betelang_profile_image)
    val Name : TextView = view.findViewById(R.id.betelang_name_tv)
    val Aff : TextView = view.findViewById(R.id.betelang_affiliation_tv)
    val Clear : TextView = view.findViewById(R.id.betelang_num_tv)

    fun onBind(data : ExpertBetelangData){
        Name.text = data.betelang_Name
        Aff.text = data.betelang_aff
        Clear.text = data.betelang_Clear_Num
    }
}