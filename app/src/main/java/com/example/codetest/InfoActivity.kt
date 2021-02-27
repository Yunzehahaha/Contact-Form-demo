package com.example.codetest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.codetest.utils.Utils
import kotlinx.android.synthetic.main.activity_info.*


class InfoActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val intent = intent
        val id = intent.extras!!.getString("id")
        val detailInfo = Utils.getDetail(id ?: "")

        firstName.setText(detailInfo?.firstName, TextView.BufferType.EDITABLE)
        lastName.setText(detailInfo?.lastName, TextView.BufferType.EDITABLE)
        email.setText(detailInfo?.email, TextView.BufferType.EDITABLE)
        phone.setText(detailInfo?.phone, TextView.BufferType.EDITABLE)

        save.setOnClickListener {
            if (firstName.text.toString().isEmpty() || lastName.text.toString().isEmpty()) {
                Toast.makeText(this, "First Name and Last Name cannot be empty", Toast.LENGTH_LONG).show()
               // return@setOnClickListener
            } else {
                detailInfo?.firstName = firstName.text.toString()
                detailInfo?.lastName = lastName.text.toString()
                detailInfo?.email = email.text.toString()
                detailInfo?.phone = phone.text.toString()
                Utils.saveToJson(id ?: "", detailInfo)
                Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show()
            }
        }

        cancel.setOnClickListener {
            Toast.makeText(this, "Function Is Not Working Now", Toast.LENGTH_LONG).show()
            //return@setOnClickListener
        }
    }
}