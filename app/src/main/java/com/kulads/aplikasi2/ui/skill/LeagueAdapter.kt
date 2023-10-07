package com.kulads.aplikasi2.ui.skill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LeagueAdapter(var mutableList: MutableList<LanguageData>) :
    RecyclerView.Adapter<LeagueAdapter.LaguageViewHolder>() {

    inner class LaguageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val titleTv : TextView = itemView.findViewById(R.id.titleTv)
    }

    fun setFilteredList(mutableList: MutableList<LanguageData>){
        this.mutableList = mutableList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item , parent , false)
        return LaguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: LaguageViewHolder, position: Int) {
        holder.logo.setImageResource(mutableList[position].logo)
        holder.titleTv.text = mutableList[position].title
    }
}