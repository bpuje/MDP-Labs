package edu.mum.cs473.walmartstore

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_clothing.*

class ClothingList : AppCompatActivity() {

    var images = intArrayOf(R.drawable.coat,
        R.drawable.dress,
        R.drawable.pants,
        R.drawable.shirt,
        R.drawable.gutal,
        R.drawable.shorts,
        R.drawable.sweater,
        R.drawable.sweetshirt)

    var clothes = arrayOf<String>("Dress", "Pants", "Shirt", "Shoes", "Shorts", "Sweater", "Sweetshirt")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clothing)

        val adapter = ArrayAdapter<String>(this@ClothingList, android.R.layout.simple_spinner_dropdown_item, clothes)
        lview.adapter = adapter
        lview.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val item = parent.getItemAtPosition(position).toString()
            val intent1 = Intent(applicationContext, ClothingDetails::class.java)
            intent1.putExtra("image", images[position])
            startActivity(intent1)
        }
    }

    fun setOnClickClothingImage(view: View){

        Toast.makeText(this, "Welcome to electronics category. ", Toast.LENGTH_LONG).show()
        val intent1 = Intent(this, ClothingList::class.java)
        startActivityForResult(intent1, 1)

//        when(view){
//            imageElectronic -> {
//                Toast.makeText(this, "Welcome to an Electronic category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ClothingList::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageBaby -> {
//                Toast.makeText(this, "Welcome to an Baby's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ClothingList::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageCosmetic -> {
//                Toast.makeText(this, "Welcome to an Cosmetic's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ClothingList::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageMedicine -> {
//                Toast.makeText(this, "Welcome to an Medicine's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ClothingList::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageCarOil -> {
//                Toast.makeText(this, "Welcome to an Car Oil's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ClothingList::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageVagetables -> {
//                Toast.makeText(this, "Welcome to an Vagetable's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ClothingList::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//        }
    }

}