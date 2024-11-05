package com.example.projectuaslab6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter untuk RecyclerView yang menampilkan daftar FoodItem
class FoodAdapter(private val foodList: List<FoodItem>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    // ViewHolder untuk mengikat data ke tampilan
    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodDescription: TextView = itemView.findViewById(R.id.foodDescription)
        val foodTags: TextView = itemView.findViewById(R.id.foodTags)
    }

    // Membuat ViewHolder baru untuk setiap item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_food_item, parent, false)
        return FoodViewHolder(view)
    }

    // Mengikat data dari FoodItem ke dalam tampilan
    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val foodItem = foodList[position]
        holder.foodName.text = foodItem.name
        holder.foodDescription.text = foodItem.description
        holder.foodTags.text = foodItem.tags.joinToString(" | ")
    }

    // Mengembalikan jumlah item dalam daftar
    override fun getItemCount() = foodList.size
}
