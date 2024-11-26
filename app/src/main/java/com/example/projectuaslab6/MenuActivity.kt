package com.example.mealgo

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var menuTitle: TextView
    private lateinit var description: TextView
    private lateinit var ingredients: LinearLayout
    private lateinit var instructions: TextView
    private lateinit var menuImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Inisialisasi Firebase Firestore
        firestore = FirebaseFirestore.getInstance()

        // Inisialisasi Views
        menuTitle = findViewById(R.id.menuTitle)
        description = findViewById(R.id.description)
        ingredients = findViewById(R.id.ingredients)
        instructions = findViewById(R.id.instructions)
        menuImage = findViewById(R.id.menu_image)

        // Ambil ID menu dari Intent atau parameter lain
        val menuId = intent.getStringExtra("MENU_ID") ?: return

        // Ambil data dari Firestore
        firestore.collection("menus").document(menuId)
            .get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val menuData = document.toObject(Menu::class.java)

                    // Set data ke UI
                    menuTitle.text = menuData?.name
                    description.text = menuData?.description
                    instructions.text = menuData?.instructions
                    // Set image
                    Glide.with(this).load(menuData?.imageUrl).into(menuImage)

                    // Menampilkan bahan-bahan
                    menuData?.ingredients?.forEach { ingredient ->
                        val ingredientView = LayoutInflater.from(this)
                            .inflate(R.layout.ingredient_item, ingredients, false)
                        val ingredientImage = ingredientView.findViewById<ImageView>(R.id.ingredientImage)
                        val ingredientText = ingredientView.findViewById<TextView>(R.id.ingredientText)

                        Glide.with(this).load(ingredient.imageUrl).into(ingredientImage)
                        ingredientText.text = ingredient.name
                        ingredients.addView(ingredientView)
                    }
                }
            }
            .addOnFailureListener {
                // Handle error
            }
    }
}