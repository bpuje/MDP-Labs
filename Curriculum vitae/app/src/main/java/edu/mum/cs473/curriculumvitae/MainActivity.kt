package edu.mum.cs473.curriculumvitae

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import edu.mum.cs473.curriculumvitae.classes.Person

class MainActivity : AppCompatActivity() {

    lateinit var fmanager : FragmentManager
    lateinit var txn : FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fmanager = supportFragmentManager
        txn = fmanager.beginTransaction()
        txn.add(R.id.frameId, HomeFragment())
        txn.commit()

        init()


        // homeIntent
        if(intent.hasExtra("personList")){
            var person =intent.getSerializableExtra("person") as Person



        }
    }

    fun init(){

        //listItems.add(dateformat.format(Date()))
        var p1 = (Person(1, "Battuguldur", "Ganbold", "tuugii", "650-745-6863", "tuugii83@gmail.com", "gtuugii", "gtuugii", "Tuugii description "))

    }


    fun onHomeBtn(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frameId, HomeFragment())
        txn.commit()
    }

    fun onAboutBtn(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frameId, AboutFragment())
        txn.commit()
    }

    fun onWorkBtn(view: View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frameId, WorkFragment())
        txn.commit()
    }

    fun onContactBtn(view :View){
        txn = fmanager.beginTransaction()
        txn.replace(R.id.frameId, ContactFragment())
        txn.commit()
    }
}
