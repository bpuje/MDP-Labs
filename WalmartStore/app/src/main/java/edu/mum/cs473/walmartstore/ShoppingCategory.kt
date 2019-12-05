package edu.mum.cs473.walmartstore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shopping_category.*


class ShoppingCategory : AppCompatActivity(){

    var username : String? = ""
    var productList = ArrayList<Product>()


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)


        val intent1 = intent
        val output = intent1.getStringExtra("You have chosen the Clothing category of shopping")
        productList =intent.getSerializableExtra("productList") as ArrayList<Product>
        txtWelcome.text = output

    }

    fun setOnClickCategory(view: View){
        val intent1 = Intent(this, ClothingList::class.java)
        startActivityForResult(intent1, 1)
    }

    fun setOnClictElect(view: View){
        val intent1 = Intent(this, ElectronActivity::class.java)
        intent1.putExtra("productList", productList)
        startActivity(intent1)
    }



//    fun setOnClickClothingImage(view: View){
////        Toast.makeText(this, "Welcome to electronics category. ", Toast.LENGTH_LONG).show()
////        val intent1 = Intent(this, ClothingList::class.java)
////        startActivityForResult(intent1, 1)
//
//        when(view){
//            imageElectronic -> {
//                Toast.makeText(this, "Welcome to an Electronic category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ShoppingCategory::class.java)
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
//                var intent1 = Intent(this, ShoppingCategory::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageMedicine -> {
//                Toast.makeText(this, "Welcome to an Medicine's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ShoppingCategory::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageCarOil -> {
//                Toast.makeText(this, "Welcome to an Car Oil's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ShoppingCategory::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//
//            imageVagetables -> {
//                Toast.makeText(this, "Welcome to an Vagetable's category.", Toast.LENGTH_LONG).show()
//                var intent1 = Intent(this, ShoppingCategory::class.java)
//                intent1.putExtra("productList", clothes )
//                startActivity(intent1)
//            }
//        }
//
//    }
}