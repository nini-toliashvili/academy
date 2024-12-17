package com.example.homework_3

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_3.databinding.Homework8Binding

class Homework8:AppCompatActivity() {
    private lateinit var binding: Homework8Binding
    private val users = mutableListOf<User>()
    private var deletionCount = 0
    var operation = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Homework8Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }


    private fun setUp() {
        val stringTemp = "Deleted Users: $deletionCount"
        binding.deletedUsers.text = stringTemp

        val stringTemp2 = "Active Users: ${users.size}"
        binding.activeUsers.text = stringTemp2
        listeners()

    }


    private fun listeners() {
        var validNewUser = true
        var validUpdateUser = false
        val userAdded = "user added successfully"
        val userNotAdded = "user already exists"
        val userDeleted = "user deleted successfully"
        var userNotExists = "user does not exist"
        binding.addUser.setOnClickListener {

            if (binding.firstName.text.toString() =="") binding.firstName.error = "field can not be empty"
            if (binding.lastName.text.toString() =="") binding.lastName.error = "field can not be empty"
            if (binding.age.text.toString() =="") binding.age.error = "field can not be empty"
            if (binding.email.text.toString() =="") binding.email.error = "field can not be empty"

            val firstname = binding.firstName.text.toString()
            val lastname = binding.lastName.text.toString()
            val age = binding.age.text.toString().toInt()
            val email = binding.email.text.toString()
            val newUser = User(firstname, lastname, age, email)
            for (i in users) {
                if (i.email == newUser.email) validNewUser = false
            }
            if(!validNewUser) {binding.success.text = userNotAdded
                binding.success.setTextColor(Color.RED)
            } else {
                users.add(newUser)
                binding.success.text = userAdded
                binding.success.setTextColor(Color.GREEN)
            }
            val stringTemp2 = "Active Users: ${users.size}"
            binding.activeUsers.text = stringTemp2


            binding.firstName.setText("")
            binding.lastName.setText("")
            binding.age.setText("")
            binding.email.setText("")


        }

        binding.removeUser.setOnClickListener {

            if (binding.firstName.text.toString() =="") binding.firstName.error = "field can not be empty"
            if (binding.lastName.text.toString() =="") binding.lastName.error = "field can not be empty"
            if (binding.age.text.toString() =="") binding.age.error = "field can not be empty"
            if (binding.email.text.toString() =="") binding.email.error = "field can not be empty"

            val firstname = binding.firstName.text.toString()
            val lastname = binding.lastName.text.toString()
            val age = binding.age.text.toString().toInt()
            val email = binding.email.text.toString()
            val checkUser = User(firstname, lastname, age, email)
        for (i in users) {
            if (i == checkUser) {users.remove(i)
                deletionCount++
                operation = true
                break
            }

        }

            val stringTemp = "Deleted Users: $deletionCount"
            binding.deletedUsers.text = stringTemp
            val stringTemp2 = "Active Users: ${users.size}"
            binding.activeUsers.text = stringTemp2
            if (operation) {
            binding.success.text = userDeleted
                binding.success.setTextColor(Color.GREEN)
            } else {
                binding.success.text = userNotExists
                binding.success.setTextColor(Color.RED)
            }

            binding.firstName.setText("")
            binding.lastName.setText("")
            binding.age.setText("")
            binding.email.setText("")

        }

        binding.updateUser.setOnClickListener {

            if (binding.firstName.text.toString() =="") binding.firstName.error = "field can not be empty"
            if (binding.lastName.text.toString() =="") binding.lastName.error = "field can not be empty"
            if (binding.age.text.toString() =="") binding.age.error = "field can not be empty"
            if (binding.email.text.toString() =="") binding.email.error = "field can not be empty"

            val firstname = binding.firstName.text.toString()
            val lastname = binding.lastName.text.toString()
            val age = binding.age.text.toString().toInt()
            val email = binding.email.text.toString()
            val updateUser = User(firstname, lastname, age, email)
            for (i in users) {
                if (i.email == updateUser.email) validUpdateUser = true
            }
            if (validUpdateUser) {updateUser.firstName = firstname
            updateUser.lastName = lastname
            updateUser.age = age}


            binding.firstName.setText("")
            binding.lastName.setText("")
            binding.age.setText("")
            binding.email.setText("")

        }
        }
    }
