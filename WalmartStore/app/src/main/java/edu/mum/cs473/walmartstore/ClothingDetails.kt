package edu.mum.cs473.walmartstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ClothingDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothing_details)
        val id = intent.getIntExtra("image", 0)

        // Drawable Resource id
        imageView.setImageResource(id)
    }
}