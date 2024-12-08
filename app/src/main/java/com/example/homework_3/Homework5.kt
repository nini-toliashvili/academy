package com.example.homework_3

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.Visibility
import com.example.homework_3.databinding.Homework5Binding

private lateinit var binding: Homework5Binding

class Homework5:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var count:Int = 0
        super.onCreate(savedInstanceState)
        binding = Homework5Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val users = mutableMapOf<String, String>()

        binding.saveUser.setOnClickListener {

            var valid = true
            if (binding.fullName.text.toString() == "") {binding.fullName.error = "Name field can not be empty!"
                valid = false}
            if (binding.emailAddress.text.toString() == "") {binding.emailAddress.error = "Email address field can not be empty!"
            valid = false}


            if (valid) {
                count++
                val temp = "users -> $count"
                binding.userCount.text = temp
                users[binding.emailAddress.text.toString()] = binding.fullName.text.toString()

                binding.fullName.setText("")
                binding.emailAddress.setText("")
            }
        }

        binding.getUserButton.setOnClickListener {
            val noUser = "User not found"

            if (binding.getUser.text.toString() == "") binding.getUser.error = "please, provide an email"
            else {
                if (users.isEmpty() || !users.containsKey(binding.getUser.text.toString())) {
                    binding.userInfo.text = noUser
                    binding.userInfo.visibility = View.VISIBLE
                }
                else {
                    val mail = binding.getUser.text.toString()
                    val name = users[binding.getUser.text.toString()]
                    val regNumber = users.keys.toList().indexOf(mail) +1

                    val foundUser = """
                        Email address: $mail 
                        Full name: $name 
                        $regNumber to register  """.trimIndent()
                    binding.userInfo.text = foundUser
                    binding.userInfo.visibility = View.VISIBLE
                    binding.getUser.setText("")


                }

            }
        }

    }

}