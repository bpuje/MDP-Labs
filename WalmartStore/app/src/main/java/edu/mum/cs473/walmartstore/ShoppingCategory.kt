package edu.mum.cs473.walmartstore

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*


class ShoppingCategory : AppCompatActivity(){

    var username : String? = ""

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val intent1 = intent
        val output = intent1.getStringExtra("You have chosen the Clothing category of shopping")
        txtWelcome.text = output

        Toast.makeText(this, "Welcome " + username, Toast.LENGTH_LONG).show()
    }

    fun setOnClickCategory(view: View){
        Toast.makeText(this, "Welcome " + username, Toast.LENGTH_LONG).show()

    }
}