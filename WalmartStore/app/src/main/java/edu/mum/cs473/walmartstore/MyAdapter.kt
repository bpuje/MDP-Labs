package edu.mum.cs473.walmartstore

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
                var context: Context,
                var prodList : ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<TextView>(R.id.title)
        var price: TextView = itemView.findViewById<TextView>(R.id.price)
        var color: TextView = itemView.findViewById<TextView>(R.id.color)
        var im : ImageView = itemView.findViewById<ImageView>(R.id.imageView)
        var parentlayout : RelativeLayout = itemView.findViewById(R.id.playout) as RelativeLayout
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.im.setImageResource(prodList[position].image)
        holder.title.text = prodList[position].title.toString()
        holder.price.text = "Price : "+ prodList[position].price.toString()
        holder.color.text = "Color : " + prodList[position].color.toString()

        holder.parentlayout.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            var res = prodList[position]
            Toast.makeText(context," $res clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("product", prodList[position])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v);
    }
    override fun getItemCount(): Int {
        return prodList.size
    }



}