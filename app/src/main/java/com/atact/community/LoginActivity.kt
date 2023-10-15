package com.atact.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        login_by_phone.setOnClickListener{
            val intent = Intent(this@LoginActivity, PhoneLoginActivity::class.java)
            startActivity(intent)
        }
        login_by_email.setOnClickListener{
            val intent = Intent(this@LoginActivity, EmailLoginActivity::class.java)
            startActivity(intent)
        }
        request_account.setOnClickListener{
            val intent = Intent(this@LoginActivity, PropertySelectionActivity::class.java)
            startActivity(intent)
        }
    }
}