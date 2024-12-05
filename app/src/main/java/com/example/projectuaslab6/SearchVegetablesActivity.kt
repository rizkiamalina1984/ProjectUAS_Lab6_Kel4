package com.example.projectuaslab6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchVegetablesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_vegetables)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val readMoreButton1 = findViewById<Button>(R.id.readMoreButton1)
        val readMoreButton2 = findViewById<Button>(R.id.readMoreButton2)
        val readMoreButton3 = findViewById<Button>(R.id.readMoreButton3)
        val readMoreButton4 = findViewById<Button>(R.id.readMoreButton4)

        readMoreButton1.setOnClickListener {
            val recipeId1 = "pdq7FXMuDX1VaRac7iNt"
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId1) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton2.setOnClickListener {
            val recipeId2 = "m1HmaZSFwHaV4mrByFkq"
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId2) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton3.setOnClickListener {
            val recipeId3 = "a40Am7WiHtQkLhCF5Hwo"
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId3) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton4.setOnClickListener {
            val recipeId4 = "CPvNpp5xlcdSMvZdwsba"
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId4) // Mengirimkan recipeId ke MenuActivity
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