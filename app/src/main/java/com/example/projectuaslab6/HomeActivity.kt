package com.example.projectuaslab6

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // Mengatur padding sesuai dengan insets dari system bars (status dan navigation bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom)
            insets
        }
    }

    // Fungsi untuk mengaktifkan tampilan edge-to-edge
    private fun enableEdgeToEdge() {
        // Mengaktifkan tampilan full screen tanpa batas
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Mengatur tampilan status bar dan navigation bar
        val windowInsetsController = WindowInsetsControllerCompat(window, window.decorView)
        windowInsetsController.isAppearanceLightStatusBars = true // Agar ikon status bar lebih gelap
        windowInsetsController.isAppearanceLightNavigationBars = true // Agar ikon navigation bar lebih gelap
    }
}
