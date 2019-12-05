package edu.mum.cs473.walmartstore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_layout.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)

        // To avoid application crash check intent has data or not
        if(intent.hasExtra("product")){
            var prod =intent.getSerializableExtra("product") as Product

            imageView.setImageResource(prod.image)
            itemTitle.text = prod.title.toString()
            colorId.text = "Color : "+ prod.color.toString()
            itemId.text = "Wallmart #: " + prod.itemId.toString()
            desc.text = prod.desc.toString()


        }
    }
}