package com.example.projectuaslab6

// Data class untuk menyimpan informasi tentang item makanan
data class FoodItem(
    val name: String,           // Nama makanan
    val description: String,     // Deskripsi makanan
    val tags: List<String>       // Daftar tag untuk makanan (misalnya "Meat", "Vegetables")
)
