package com.example.codetest.view

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.codetest.R
import com.example.codetest.utils.Utils
import kotlinx.android.synthetic.main.activity_info.*


class InfoActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val intent = intent
        val id = intent.extras!!.getString("id")
        //val detailInfo = Utils.getDetail(id ?: "")
        val firstNameString = intent.extras!!.getString("firstName")
        val lastNameString = intent.extras!!.getString("lastName")
        val emailString = intent.extras!!.getString("email")
        val phoneString = intent.extras!!.getString("phone")

        firstName.setText(firstNameString , TextView.BufferType.EDITABLE)
        lastName.setText(lastNameString, TextView.BufferType.EDITABLE)
        email.setText(emailString, TextView.BufferType.EDITABLE)
        phone.setText(phoneString, TextView.BufferType.EDITABLE)

        val replyIntent = Intent()

        save.setOnClickListener {
            if (firstName.text.toString().isEmpty() || lastName.text.toString().isEmpty()) {
                Toast.makeText(this, "First Name and Last Name cannot be empty", Toast.LENGTH_LONG).show()
               // return@setOnClickListener
            } else {
                replyIntent.putExtra("id", id)
                replyIntent.putExtra("firstName", firstName.text.toString())
                replyIntent.putExtra("lastName", lastName.text.toString())
                replyIntent.putExtra("email", email.text.toString())
                replyIntent.putExtra("phone", phone.text.toString())
                setResult(Activity.RESULT_OK, replyIntent)
                //Utils.saveToJson(id ?: "", detailInfo)
                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        cancel.setOnClickListener {
            Toast.makeText(this, "Function Is Not Working Now", Toast.LENGTH_LONG).show()
            //return@setOnClickListener
        }
    }
}