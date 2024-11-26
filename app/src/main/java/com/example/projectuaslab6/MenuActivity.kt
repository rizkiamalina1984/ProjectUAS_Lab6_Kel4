package com.example.tesfirestoremenu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.bumptech.glide.Glide
import com.example.projectuaslab6.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var storageRef: StorageReference
    private lateinit var db: FirebaseFirestore
    private val PICK_IMAGE_REQUEST = 71

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Firebase
        imageView = findViewById(R.id.menu_image)
        storageRef = FirebaseStorage.getInstance().reference
        db = FirebaseFirestore.getInstance()

        // Tombol untuk memilih gambar
        val selectImageButton = findViewById<ImageView>(R.id.left_arrow)
        selectImageButton.setOnClickListener {
            openGallery()
        }
    }

    // Fungsi untuk memilih gambar dari galeri
    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    // Mengambil hasil gambar yang dipilih
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            imageUri?.let { uploadImage(it) }
        }
    }

    // Fungsi untuk mengupload gambar ke Firebase Storage
    private fun uploadImage(imageUri: Uri) {
        val imageRef = storageRef.child("images/${imageUri.lastPathSegment}")

        imageRef.putFile(imageUri)
            .addOnSuccessListener {
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    val imageUrl = uri.toString()
                    saveImageUrlToFirestore(imageUrl)
                    Toast.makeText(this, "Upload Berhasil!", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Upload Gagal: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    // Menyimpan URL gambar ke Firestore
    private fun saveImageUrlToFirestore(imageUrl: String) {
        val menuData = hashMapOf(
            "imageUrl" to imageUrl
        )

        db.collection("menus")
            .document("menu1")
            .set(menuData)
            .addOnSuccessListener {
                Toast.makeText(this, "Data Tersimpan!", Toast.LENGTH_SHORT).show()
                loadImageFromFirestore()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Gagal menyimpan data: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    // Mengambil URL gambar dari Firestore dan menampilkannya
    private fun loadImageFromFirestore() {
        db.collection("menus")
            .document("menu1")
            .get()
            .addOnSuccessListener { document ->
                val imageUrl = document.getString("imageUrl")
                if (imageUrl != null) {
                    Glide.with(this)
                        .load(imageUrl)
                        .into(imageView)
                }
            }
    }
}
