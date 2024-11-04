package com.example.projectuaslab6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.projectuaslab6.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val registerButton: Button = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            // Lakukan pendaftaran, lalu kembali ke halaman login
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

