package com.example.projectuaslab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectuaslab6.FoodAdapter
import com.example.projectuaslab6.R

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodItems = listOf(
            FoodItem("Pasta Salad", "Fresh pasta with vegetables and basil", listOf("Meat", "Vegetables")),
            FoodItem("Vegetable Kebab", "Kebab skewers with fresh, roasted vegetables and meat", listOf("Meat", "Vegetables")),
            // Add more food items here as per your list
        )

        val adapter = FoodAdapter(foodItems)
        recyclerView.adapter = adapter
    }
}
