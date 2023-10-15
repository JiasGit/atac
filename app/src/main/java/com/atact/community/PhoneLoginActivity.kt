package com.atact.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_email_login.*
import kotlinx.android.synthetic.main.activity_phone_login.*

class PhoneLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_login)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.back)

        button_next.setOnClickListener{
            //read input
            val inputPhoneNumber = editTextPhone.text.toString().trim()

            // Check if input is valid
            if(inputPhoneNumber.length != 8 ) {
                editTextPhone.error = getString(R.string.enter_valid_number)
                return@setOnClickListener
            }

            val intent = Intent(this, PhoneOtpActivity::class.java)
            startActivity(intent)
        }
    }
}