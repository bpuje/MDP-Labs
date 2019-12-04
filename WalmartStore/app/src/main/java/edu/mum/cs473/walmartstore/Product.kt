package edu.mum.cs473.walmartstore

import java.io.Serializable

class Product(var title: String?, var price: Double?,
              var color: String?, var image: Int?,
              var itemId: String?, var desc: String?) : Serializable{

    override fun toString(): String {
        return "itemId=$itemId, Product(title=$title, " +
                "price=$price, desc=$desc)"
    }

//    fun getProductList(){}
}