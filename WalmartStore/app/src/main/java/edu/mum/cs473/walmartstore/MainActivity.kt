package edu.mum.cs473.walmartstore

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.editEmail
import kotlinx.android.synthetic.main.activity_register.editPassword

//import sun.jvm.hotspot.utilities.IntArray


class MainActivity : AppCompatActivity() {

    var myArray = ArrayList<User>()

    var productList = ArrayList<Product>()

    var input: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listApp()
        //printUser(1)

        listProduct()

        editPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
        SignInBtn.text = "Hide"

        editPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        SignInBtn.text = "Sign In"

        //SignInBtn.setOnClickListener()
    }

    fun listApp(){
        myArray.add(User("admin", "admin", "purevdemberel@gmail.com", "123"))
        myArray.add(User("John", "Doe",  "doe@gmail.com", "123"))
        myArray.add(User("Nat", "Marley", "marley@gmail.com", "123"))
        myArray.add(User("Bob", "Smith", "smith@gmail.com", "123"))
        myArray.add(User("Stella", "Delgado", "stella@gmail.com", "123"))
        myArray.add(User("a", "a", "a", "a"))
    }



    fun listProduct(){
        productList.add(Product("MackBook Pro 2020", 2500.00, "Gray", R.drawable.macboook, "1", "This Macbook is release 2020."))
        productList.add(Product("Galaxy Note 10", 1000.00, "Black", R.drawable.note10, "2", "This Samsung galaxy is released 2019."))
        productList.add(Product("Lenova Tablet", 123.00, "Black", R.drawable.tablet, "3", "This Lenove tablet is released 2019."))
        productList.add(Product("Samsung TV", 2300.00, "White", R.drawable.tv, "4", "This TV is released 2019."))
        productList.add(Product("Epson printer", 300.00, "Black", R.drawable.printer, "5", "This Epson printer is released 2019."))
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


    fun onClickNewAccount(view: View) {
        val intent1 = Intent(this, RegisterActivity::class.java)
        intent1.putExtra("msg", "Enter the required fields")
        startActivityForResult(intent1, 1)
    }

    fun onClickRecoveryPass (view: View){
        val intent1 = Intent(this, Pass_recovery::class.java)
        startActivityForResult(intent1, 2)
    }

    // revoke Register Activity
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1) {

            if (resultCode == Activity.RESULT_OK) {
                val returnedResult = data!!.getSerializableExtra("user")
                var user = returnedResult as User
                myArray.add(user)
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
            }
            else
                Toast.makeText(this, "Account is not created", Toast.LENGTH_LONG).show()
        }

        if(requestCode == 2){
            if(resultCode == Activity.RESULT_OK){
                val returnedResult = data!!.getStringExtra("email")

                var rPass : String? = ""
                for (user in myArray){
                    if(user.email.equals(returnedResult)){
                        rPass = user.password
                        val intent1 = Intent()
                        intent1.action = Intent.ACTION_SEND
                        //intent1.action = Intent.ACTION_SENDTO
                        //intent1.setData(Uri.parse(returnedResult))
                        intent1.type = "text/plain"
                        intent1.putExtra(Intent.EXTRA_EMAIL, returnedResult)
                        intent1.putExtra(Intent.EXTRA_TEXT, rPass)
                        intent1.putExtra(Intent.EXTRA_SUBJECT, "Recovered Password")
                        startActivity(intent1)

                        Toast.makeText(this, "Sending email......", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
