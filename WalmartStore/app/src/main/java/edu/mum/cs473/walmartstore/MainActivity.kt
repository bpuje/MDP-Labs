package edu.mum.cs473.walmartstore

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
//import sun.jvm.hotspot.utilities.IntArray


class MainActivity : AppCompatActivity() {

    var myArray = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listApp()
        //printUser(1)
    }



    fun listApp(){
        myArray.add(User("admin", "admin", "admin@gmail.com", "123"))
        myArray.add(User("John", "Doe",  "doe@gmail.com", "123"))
        myArray.add(User("Nat", "Marley", "marley@gmail.com", "123"))
        myArray.add(User("Bob", "Smith", "smith@gmail.com", "123"))
        myArray.add(User("Stella", "Delgado", "stella@gmail.com", "123"))
    }

    fun setOnSingIn(view: View){
        var username: String?
        var password: String?
        var msg: String? = ""

        username = editEmail.text.toString()
        password = editPassword.text.toString()

        if(checkValidation(username, password)){
            //Toast.makeText(this, "check valid",  Toast.LENGTH_LONG).show()

            val toast = Toast.makeText(
                applicationContext, "Welcome to Categories", Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
            toast.show()

            for (user in myArray){
                if (user.email.equals(username) && user.password.equals(password)){
                    msg = user.email
                    break
                }
            }
            if (msg != ""){
                Toast.makeText(this, "Hi there! This is  a  Toast.",  Toast.LENGTH_LONG).show()

                val intent1 = Intent(this, ShoppingCategory::class.java)
                intent1.putExtra("msg", msg)
                startActivity(intent1)

            }
        }
    }

    fun checkValidation(username: String, password: String): Boolean{

        if(username.isEmpty()) {
            Toast.makeText(this, "Enter UserName", Toast.LENGTH_LONG).show()
            return false
        }

        if(password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

    //createAcctBtn
    fun onClickNewAccount(view: View) {
        val intent1 = Intent(this, RegisterActivity::class.java)
        intent1.putExtra("msg", "Enter the required fields")
        startActivity(intent1)
    }
}
