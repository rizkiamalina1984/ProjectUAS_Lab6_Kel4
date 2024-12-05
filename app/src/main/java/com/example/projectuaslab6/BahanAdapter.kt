package com.example.projectuaslab6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BahanAdapter(private val bahanList: List<String>) :
    RecyclerView.Adapter<BahanAdapter.BahanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BahanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return BahanViewHolder(view)
    }

    override fun onBindViewHolder(holder: BahanViewHolder, position: Int) {
        holder.bahanTextView.text = bahanList[position]
    }

    override fun getItemCount(): Int {
        return bahanList.size
    }

    class BahanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bahanTextView: TextView = itemView.findViewById(android.R.id.text1)
    }
}
