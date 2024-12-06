package com.example.homework_3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Homework4 : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homework_4)
        val emailAddress: EditText = findViewById(R.id.email)
        val username: EditText = findViewById(R.id.username)
        val firstname: EditText = findViewById(R.id.firstname)
        val lastname: EditText = findViewById(R.id.lastname)
        val age: EditText = findViewById(R.id.age)
        val save: Button = findViewById(R.id.save)
        val clear: Button = findViewById(R.id.clear_text)
        var isValid:Boolean = true
        val emailInfo :TextView = findViewById(R.id.email_info)
        val usernameInfo :TextView = findViewById(R.id.username_info)
        val name :TextView = findViewById(R.id.name)
        val ageInfo :TextView = findViewById(R.id.age_info)
        val again :Button = findViewById(R.id.again)




        save.setOnClickListener {
            val emailText:String = emailAddress.text.toString()
            val usernameText:String = username.text.toString()
            val firstnameText:String = firstname.text.toString()
            val lastnameText:String = lastname.text.toString()
            val ageToText:String = age.text.toString()
            if (emailText.isEmpty()) {
                emailAddress.error = "email field can not be empty!"
                isValid = false
            } else if (!emailText.contains('@')) {
                emailAddress.error = "your address is not valid"
                isValid = false
            }
            if (usernameText.isEmpty()) {
                username.error = "username field can not be empty!"
                isValid = false

            }
            else if (usernameText.length <=10) {
                username.error = "username length must be more than 10!"
                isValid = false
            }
            if (firstnameText.isEmpty()) {
                firstname.error = "firstname field can not be empty!"
                isValid = false
            }
            if (lastnameText.isEmpty()) {
                lastname.error = "lastname field can not be empty!"
                isValid = false
            }
            if (ageToText.isEmpty()) {
                age.error = "age field can not be empty!"
                isValid = false
            } else if (ageToText.contains("[^0-9]".toRegex())) {
                age.error = "your input is invalid"
                isValid = false
            }




            if (isValid) {
               emailInfo.text = emailAddress.text
               usernameInfo.text = username.text
               name.text = firstname.text.toString() + " " + lastname.text.toString()
               ageInfo.text = age.text
               emailAddress.visibility = View.GONE
               username.visibility = View.GONE
               firstname.visibility = View.GONE
               lastname.visibility = View.GONE
               age.visibility = View.GONE
               save.visibility = View.GONE
               clear.visibility = View.GONE
               emailInfo.visibility = View.VISIBLE
               usernameInfo.visibility = View.VISIBLE
               name.visibility = View.VISIBLE
               ageInfo.visibility = View.VISIBLE
               again.visibility = View.VISIBLE

            }


        }

        clear.setOnLongClickListener {
            emailAddress.setText("")
            username.setText("")
            firstname.setText("")
            lastname.setText("")
            age.setText("")
        true
        }

        again.setOnClickListener {
            emailAddress.setText("")
            username.setText("")
            firstname.setText("")
            lastname.setText("")
            age.setText("")

            emailInfo.visibility = View.GONE
            usernameInfo.visibility = View.GONE
            name.visibility = View.GONE
            ageInfo.visibility = View.GONE
            again.visibility = View.GONE

            emailAddress.visibility = View.VISIBLE
            username.visibility = View.VISIBLE
            firstname.visibility = View.VISIBLE
            lastname.visibility = View.VISIBLE
            age.visibility = View.VISIBLE
            save.visibility = View.VISIBLE
            clear.visibility = View.VISIBLE
        }


    }
}