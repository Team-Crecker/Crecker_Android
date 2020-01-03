package org.techtown.crecker.law.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import org.techtown.crecker.R
import org.techtown.crecker.law.data.BetelangApiData


class ExpertBetelangVH(view : View) : RecyclerView.ViewHolder(view){
    val glideManager : RequestManager = Glide.with(itemView)

    val Profile : ImageView = view.findViewById(R.id.betelang_profile_image)
    val Name : TextView = view.findViewById(R.id.a_betelang_name_tv)
    val Aff : TextView = view.findViewById(R.id.a_betelang_affiliation_tv)
    val Clear : TextView = view.findViewById(R.id.betelang_num_tv)

    fun onBind(data : BetelangApiData.Data){
        loading(data.profile, Profile)
        Name.text = data.betelang_Name
        Aff.text = data.betelang_aff
        Clear.text = data.betelang_Clear_Num.toString()
    }

    private fun loading(url : String, view : ImageView){
        view.post{
            glideManager.load(url).into(view)
        }
    }
}