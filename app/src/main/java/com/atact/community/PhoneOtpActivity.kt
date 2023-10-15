package com.atact.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PhoneOtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_otp)

        supportActionBar!!.title = getString(R.string.back)
    }
}