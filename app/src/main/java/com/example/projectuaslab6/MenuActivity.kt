package com.example.projectuaslab6

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Referensi Firestore
        val db = FirebaseFirestore.getInstance()

        // Ambil RECIPE_ID dari Intent
        val recipeId = intent.getStringExtra("RECIPE_ID")

        // Jika RECIPE_ID tidak ada, tampilkan pesan error
        if (recipeId.isNullOrEmpty()) {
            Toast.makeText(this, "ID resep tidak ditemukan!", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val imageButton: ImageButton = findViewById(R.id.white_left_arrow)

        // Set OnClickListener pada ImageButton
        imageButton.setOnClickListener {
            val intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)
        }

        // Inisialisasi Views
        val titleTextView: TextView = findViewById(R.id.menuTitle)
        val nameTextView: TextView = findViewById(R.id.menuNameTextView)
        val descriptionTextView: TextView = findViewById(R.id.menuDescriptionTextView)
        val toolsRecyclerView: RecyclerView = findViewById(R.id.menuToolsRecyclerView)
        val ingredientsTextView: TextView = findViewById(R.id.menuIngredientsTextView)

        // Set layout manager untuk RecyclerView
        toolsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Ambil data dari Firestore berdasarkan RECIPE_ID
        db.collection("menu")
            .document(recipeId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    // Ambil data dari dokumen
                    val title = document.getString("nama") ?: "Nama tidak tersedia"
                    val description = document.getString("deskripsi") ?: "Deskripsi tidak tersedia"
                    val ingredients = document.get("bahan") as? List<String> ?: emptyList()
                    val steps = document.getString("langkah") ?: "Langkah tidak tersedia"

                    // Tampilkan data di Views
                    titleTextView.text = title
                    nameTextView.text = title
                    descriptionTextView.text = description
                    ingredientsTextView.text = steps

                    // Set adapter untuk RecyclerView (bahan-bahan)
                    val adapter = ToolsAdapter(ingredients)
                    toolsRecyclerView.adapter = adapter
                } else {
                    Toast.makeText(this, "Resep tidak ditemukan!", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Log.e("MenuActivity", "Gagal mengambil data: ", exception)
                Toast.makeText(this, "Gagal mengambil data, coba lagi nanti.", Toast.LENGTH_SHORT).show()
            }
    }
}
