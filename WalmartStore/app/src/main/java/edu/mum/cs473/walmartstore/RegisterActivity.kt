package edu.mum.cs473.walmartstore

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(){
    var msg : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val intent1 = intent
        msg = intent1.getStringExtra("msg")
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    }

    fun onClickSaveAccount(view: View){
        var fname: String = editFname.text.toString()
        var lname: String = editLname.text.toString()
        var email: String = editEmail.text.toString()
        var pass : String = editPassword.text.toString()

        //var main: MainActivity = MainActivity()

        var user = User(fname, lname, email, pass)

        val data = Intent()
        data.putExtra("user", user)

        setResult(Activity.RESULT_OK, data) //data.data = Uri.parse(text)
        finish() ////---close the activity---

        //Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
    }
}