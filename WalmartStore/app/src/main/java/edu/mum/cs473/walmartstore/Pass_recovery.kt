package edu.mum.cs473.walmartstore

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.pass_recovery.*

class Pass_recovery : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pass_recovery)
    }

    fun onClickRecoveryBtn(view: View) {
        var email = getEmail.text.toString()

        val intentData = Intent()
        intentData.putExtra("email", email)

        //intentData.data= Uri.parse(text)
        setResult(Activity.RESULT_OK, intentData)

        finish()
    }



}