package edu.mum.cs473.tablelayouttest

import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onAdd(view: View) {

        var version: String?
        var codeName: String?
        var isAdd: Boolean = true

        version = textView4.text.toString()
        codeName = textView5.text.toString()

        if(version.isEmpty()) {
            Toast.makeText(this, "Enter the version", Toast.LENGTH_LONG).show()
            isAdd = false
        }

        if(codeName.isEmpty()) {
            Toast.makeText(this, "Enter the code name", Toast.LENGTH_LONG).show()
            isAdd = false
        }

        if(isAdd){
            val tableRow = TableRow(getApplicationContext())

            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.setLayoutParams(layoutParams)

            val text_version = TextView(this)
            text_version.text = version
            tableRow.addView(text_version)

            val text_codename = TextView(this)
            text_codename.text = codeName
            tableRow.addView(text_codename)

            tblDynamic.addView(tableRow)

            Toast.makeText(this, "Added the row", Toast.LENGTH_LONG).show()

            textView4.text.clear()
            textView5.text.clear()
        }
    }


}
