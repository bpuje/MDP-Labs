package edu.mum.cs473.walmartstore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerListViewActivity : AppCompatActivity() {

    var MY_TAG = "Recycler"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_list_view)

        var intt = intent
        var alist : ArrayList<Product> = intt.getSerializableExtra("productList") as ArrayList<Product>
        Log.i(MY_TAG, alist!!.size.toString());

        recView_Book()
    }

    fun recView_Product(){}

    fun recView_Book(){
        // Get recycler view
        val rv: RecyclerView? = findViewById<RecyclerView>(R.id.recyclerView1)
        // Give the recycler view with Linear layout manager.
        rv?.layoutManager =  LinearLayoutManager(this)
        // Populate Book data list
        val books = ArrayList<Book>()
        books.add(Book("Java","Horstman"))
        books.add(Book("Kotlin","Joshua Bloch"))
        books.add(Book("JavaFX","Herbert"))
        books.add(Book("Android Essentials","Kathy"))
        books.add(Book("Android Development","Bruce"))
        books.add(Book("Kotlin Coding","Brain Goetz"))
        // Create an adapter and supply the data to be displayed.
        var adapter = CustomAdapter(books)
        // Connect the adapter with the recycler view.
        rv!!.adapter = adapter
    }
}
