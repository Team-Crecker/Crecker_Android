package org.techtown.crecker.law.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.crecker.R
import org.techtown.crecker.law.data.BetelangApiData
import org.techtown.crecker.law.viewholder.ExpertBetelangVH

class Expert_Betelang_Rv_Adp (private val context : Context) : RecyclerView.Adapter<ExpertBetelangVH>(){

    var data = listOf<BetelangApiData.Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertBetelangVH {
        val view = LayoutInflater.from(context).inflate(R.layout.expert_betelang_list_item, parent, false)
        return ExpertBetelangVH(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ExpertBetelangVH, position: Int) {
        holder.onBind(data[position])
    }

//    fun addItem(item : ExpertBetelangData){
//        data.add(item)
//    }

}