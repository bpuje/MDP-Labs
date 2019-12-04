package edu.mum.cs473.quizapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainQuiz : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

//        val currentTime = LocalDateTime.now()
//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
//        val formatted = currentTime.format(formatter)

            submit_btn.setOnClickListener{
                val builder = AlertDialog.Builder(this@MainQuiz)
                builder.setTitle("This is a result")
                builder.setMessage("Congratulations! You submitted on currentTime time Your achieved 50%")
                builder.setIcon(R.drawable.alerticon)

                builder.setPositiveButton("Yes"){
                        dialogInterface, which ->
                    Toast.makeText(applicationContext, "“Congratulations id : $which", Toast.LENGTH_SHORT).show()
                    //dialogInterface.dismiss()
                    finish()
                }

                builder.setNegativeButton("Cancel"){dialogInterface, which ->
                    Toast.makeText(applicationContext,"It's a positive action click by which id : $which",
                        Toast.LENGTH_SHORT).show()
                    dialogInterface.dismiss() // dismiss the dialog, but activity is still alive
                }

                builder.setNeutralButton("Just Thinking"){dialogInterface, which ->
                    Toast.makeText(applicationContext,"It's a neutral click by by which id : $which",
                        Toast.LENGTH_SHORT).show()
                }

                val dialog: AlertDialog = builder.create()
                dialog.show()
            }


    }

    fun onClickReset(view: View){
        radio0.clearCheck()
        checkbox1.setChecked(false)
        checkbox2.setChecked(false)
        checkbox3.setChecked(false)

    }

}