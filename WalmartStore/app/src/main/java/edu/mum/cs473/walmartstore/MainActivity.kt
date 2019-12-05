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
        productList.add(Product("MackBook Pro 2020",  2500.00, "Gray", R.drawable.macboook, "555948101", "Apple in November 2019 replaced the 15-inch MacBook Pro with a new 16-inch model, just a few months after refreshing the MacBook Pro in May and July of 2019."))
        productList.add(Product("Galaxy Note 10", 1000.00, "Black", R.drawable.note10, "555948102", "This Samsung galaxy is released 2019. The Dynamic AMOLED display on Galaxy Note10 and Note10+ received a certification from VDE Germany for 100 percent Mobile Color Volume in the DCI-P3 color range, which means your images aren’t washed out and you’ll get unbelievably vivid colors regardless of differing levels of brightness. The display can achieve peak brightness of up to 1200 nits, improving the contrast between dark and light aspects of digital content for a more brilliant picture quality, with a 2,000,000:1 contrast ratio to make your mobile experience more immersive."))
        productList.add(Product("Lenova Tablet", 123.00, "Black", R.drawable.tablet, "555948103", "This Lenove tablet is released 2019. Parents can breathe freely sharing their tablet with the kids thanks to the Lenovo Tab 10. Multi-user accounts let mom and dad tailor their children’s experience and block inappropriate content. And every member of the family will enjoy Tab 10’s big screen, robust sound, and long battery life."))
        productList.add(Product("Samsung TV", 2300.00, "White", R.drawable.tv, "555948104", "This TV is released 2019. QLED (or “Quantum dot LED”) offers an unparalleled visual and auditory adventure from the comfort of\n" +
                "your living room. Available in 4K or 8K and from 32” all the way to 98”, the QLED series was designed with\n" +
                "options to fit any space and budget."))
        productList.add(Product("Epson printer", 300.00, "Black", R.drawable.printer, "555948105", "This Epson printer is released 2019. Epson Expression ET-2650 EcoTank Wireless Color All-in-One Small Business Supertank Printer with Scanner and Copier. by Epson."))
        productList.add(Product("Headphone", 350.00, "Black", R.drawable.headset, "555948106", "Enjoy a better wireless experience with Bose® SoundLink® around-ear headphones II. Exclusive technology delivers deep, immersive sound at any volume. And a dual microphone system rejects noise and wind so you’ll be heard loud and clear. Switch seamlessly between two Bluetooth® devices, and stay connected to both. A rechargeable battery lets you listen for up to 15 hours. And intuitive touch controls give you simple command of your music and calls."))
        productList.add(Product("Canon Digital Camera",  2300.00, "Gray", R.drawable.camera, "555948107", "The first step in Canon's mirrorless evolution, the EOS R pairs a redeveloped lens mount and updated full-frame image sensor for a unique and sophisticated multimedia camera system. Revolving around the new RF lens mount, the EOS R is poised to be the means from which to make the most of a new series of lenses and optical technologies."))
        productList.add(Product("PlayStation 4", 2900.00, "Black", R.drawable.playstation, "555948108", "Experience three of the most highly celebrated PS4 games with an all-new bundle which includes a 1TB PS4, DUALSHOCK4 wireless controller and God of War, The Last of Us Remastered, and Horizon Zero Dawn: Complete Edition games."))
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
                intent1.putExtra("productList", productList)
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
