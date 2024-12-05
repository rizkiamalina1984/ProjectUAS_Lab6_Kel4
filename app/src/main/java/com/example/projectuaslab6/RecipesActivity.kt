package com.example.projectuaslab6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class RecipesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes)

        val db = FirebaseFirestore.getInstance()

        val readMoreButton1 = findViewById<Button>(R.id.readMoreButton1)
        val readMoreButton2 = findViewById<Button>(R.id.readMoreButton2)
        val readMoreButton3 = findViewById<Button>(R.id.readMoreButton3)
        val readMoreButton4 = findViewById<Button>(R.id.readMoreButton4)
        val readMoreButton5 = findViewById<Button>(R.id.readMoreButton5)
        val readMoreButton6 = findViewById<Button>(R.id.readMoreButton6)
        val readMoreButton7 = findViewById<Button>(R.id.readMoreButton7)
        val readMoreButton8 = findViewById<Button>(R.id.readMoreButton8)
        val readMoreButton9 = findViewById<Button>(R.id.readMoreButton9)
        val readMoreButton10 = findViewById<Button>(R.id.readMoreButton10)
        val readMoreButton11 = findViewById<Button>(R.id.readMoreButton11)
        val readMoreButton12 = findViewById<Button>(R.id.readMoreButton12)

        readMoreButton1.setOnClickListener {
            val recipeId1 = "pdq7FXMuDX1VaRac7iNt"  // ID untuk resep 1
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId1) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton2.setOnClickListener {
            val recipeId2 = "RtSk3kqOKgNGreItQHZ5"  // ID untuk resep 2
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId2) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton3.setOnClickListener {
            val recipeId3 = "XAGiZ1M4ACudQSaa0cYe"  // ID untuk resep 3
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId3) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton4.setOnClickListener {
            val recipeId4 = "m1HmaZSFwHaV4mrByFkq"  // ID untuk resep 4
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId4) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton5.setOnClickListener {
            val recipeId5 = "Fv8U6LNGaAaOUp6dyvoA"  // ID untuk resep 5
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId5) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton6.setOnClickListener {
            val recipeId6 = "Z4fMwaFyZCDmJ3rAw9Qs"  // ID untuk resep 6
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId6) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton7.setOnClickListener {
            val recipeId7 = "RE9b8PCWXY1FpI4647uJ"  // ID untuk resep 7
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId7) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton8.setOnClickListener {
            val recipeId8 = "ClTqggDMgnbAmPBbogvq"  // ID untuk resep 8
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId8) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton9.setOnClickListener {
            val recipeId9 = "a40Am7WiHtQkLhCF5Hwo"  // ID untuk resep 9
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId9) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton10.setOnClickListener {
            val recipeId10 = "1gjtvA2d8zLwPw3Yy5r1"  // ID untuk resep 10
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId10) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton11.setOnClickListener {
            val recipeId11 = "CPvNpp5xlcdSMvZdwsba"  // ID untuk resep 11
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId11) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }
        readMoreButton12.setOnClickListener {
            val recipeId12 = "wwcBoVztAArY6Cu3d7Ip"  // ID untuk resep 12
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("RECIPE_ID", recipeId12) // Mengirimkan recipeId ke MenuActivity
            startActivity(intent)
        }

        val imageButton1: ImageButton = findViewById(R.id.buttonsearch)
        val imageButton2: ImageButton = findViewById(R.id.buttonmenu)
        val imageButton3: ImageButton = findViewById(R.id.buttonfav)

        // Set OnClickListener pada ImageButton
        imageButton1.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        // Set OnClickListener pada ImageButton
        imageButton2.setOnClickListener {
            val intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)
        }
        // Set OnClickListener pada ImageButton
        imageButton3.setOnClickListener {
            val intent = Intent(this, FavoriteRecipesActivity::class.java)
            startActivity(intent)
        }
    }
}