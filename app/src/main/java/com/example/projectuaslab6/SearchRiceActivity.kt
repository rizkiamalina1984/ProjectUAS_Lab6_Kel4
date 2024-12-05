package com.example.projectuaslab6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchRiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_rice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val readMoreButton1 = findViewById<Button>(R.id.readMoreButton1)
        val readMoreButton2 = findViewById<Button>(R.id.readMoreButton2)

        readMoreButton1.setOnClickListener {
            val recipeId1 = "Fv8U6LNGaAaOUp6dyvoA"
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId1) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton2.setOnClickListener {
            val recipeId2 = "RE9b8PCWXY1FpI4647uJ"
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId2) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }

        val imageButton1: ImageButton = findViewById(R.id.buttonsearch)

        // Set OnClickListener pada ImageButton
        imageButton1.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        val imageButton2: ImageButton = findViewById(R.id.buttonmenu)

        // Set OnClickListener pada ImageButton
        imageButton2.setOnClickListener {
            val intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)
        }

        val imageButton3: ImageButton = findViewById(R.id.buttonfav)

        // Set OnClickListener pada ImageButton
        imageButton3.setOnClickListener {
            val intent = Intent(this, FavoriteRecipesActivity::class.java)
            startActivity(intent)
        }

    }
}