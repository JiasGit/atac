package com.atact.community

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_email_login.*
import kotlinx.android.synthetic.main.activity_phone_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.back)

        //set up spinner from a list of items
        val items_block = arrayOf("A", "B", "C")
        val adapter_block = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_block)
        spinner_block.adapter = adapter_block
        val items_unit = arrayOf("01-15", "08-19", "30-10")
        val adapter_unit = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items_unit)
        spinner_unit.adapter = adapter_unit

        button_join.setOnClickListener{
            //read input
            val inputName = register_name.text.toString()
            val inputEmail = register_email.text.toString()
            val inputNumber = register_phone.text.toString()

            // Check if input is valid
            if(inputName.isEmpty()){
                register_name.error = getString(R.string.enter_valid_name)
                register_name.requestFocus()
                return@setOnClickListener
            }
            if(!inputEmail.contains('@')) {
                register_email.error = getString(R.string.enter_valid_email)
                register_email.requestFocus()
                return@setOnClickListener
            }
            if(inputNumber.length != 8){
                register_phone.error = getString(R.string.enter_valid_number)
                return@setOnClickListener
            }
            if(!register_checkbox.isChecked){
                Toast.makeText(this, getString(R.string.request_agree_terms), Toast.LENGTH_SHORT).show()
                register_checkbox.requestFocus()
                return@setOnClickListener
            }

            // Get the checked radio button id from radio group
            var id: Int = radio_group.checkedRadioButtonId
            if (id!=-1){ // If any radio button checked from radio group
                // Get the instance of radio button using id
                val radio:RadioButton = findViewById(id)
//                Toast.makeText(this,"On button click :" +
//                        " ${radio.text}",
//                    Toast.LENGTH_SHORT).show()
            }else{
                // If no radio button checked in this radio group
                Toast.makeText(this, getString(R.string.no_radio_checked), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}