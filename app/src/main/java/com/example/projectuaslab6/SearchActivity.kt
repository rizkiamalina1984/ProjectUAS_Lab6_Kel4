package com.example.projectuaslab6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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

        val Button1: Button = findViewById(R.id.search_rice)
        val Button2: Button = findViewById(R.id.search_vegetables)
        val Button3: Button = findViewById(R.id.search_bread)
        val Button4: Button = findViewById(R.id.search_soup)
        val Button5: Button = findViewById(R.id.search_salad)
        val Button6: Button = findViewById(R.id.search_meat)
        val Button7: Button = findViewById(R.id.search_griddle_cakes)


        Button1.setOnClickListener {
            val intent = Intent(this, SearchRiceActivity::class.java)
            startActivity(intent)
        }
        Button2.setOnClickListener {
            val intent = Intent(this, SearchVegetablesActivity::class.java)
            startActivity(intent)
        }
        Button3.setOnClickListener {
            val intent = Intent(this, SearchBreadActivity::class.java)
            startActivity(intent)
        }
        Button4.setOnClickListener {
            val intent = Intent(this, SearchSoupActivity::class.java)
            startActivity(intent)
        }
        Button5.setOnClickListener {
            val intent = Intent(this, SearchSaladActivity::class.java)
            startActivity(intent)
        }
        Button6.setOnClickListener {
            val intent = Intent(this, SearchMeatActivity::class.java)
            startActivity(intent)
        }
        Button7.setOnClickListener {
            val intent = Intent(this, SearchGriddleCakesActivity::class.java)
            startActivity(intent)
        }
    }
}
