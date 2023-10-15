package com.atact.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_email_login.*
import kotlinx.android.synthetic.main.activity_phone_login.*

class EmailLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_login)

        // set up action bar back button
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.back)

        button_login.setOnClickListener{
            //read input
            val inputEmail = editText_email_address.text.toString().trim()
            val inputPassword = editText_password.text.toString().trim()

            // Check if input is valid
            if(!inputEmail.contains('@')){
                editText_email_address.error = getString(R.string.enter_valid_email)
                editText_email_address.requestFocus()
                return@setOnClickListener
            }
            if(inputPassword.isEmpty() || inputPassword.length < 6 ){
                editText_password.error = getString(R.string.enter_valid_password)
                editText_password.requestFocus()
                return@setOnClickListener
            }
            if(!checkbox_email_login.isChecked){
                Toast.makeText(this, getString(R.string.request_agree_terms), Toast.LENGTH_SHORT).show()
                checkbox_email_login.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}