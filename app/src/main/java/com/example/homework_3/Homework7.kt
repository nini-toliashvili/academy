package com.example.homework_3

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_3.databinding.Homework71Binding
import com.example.homework_3.databinding.Homework7LoginBinding
import com.example.homework_3.databinding.Homework7Register2Binding
import com.example.homework_3.databinding.Homework7RegisterBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class Homework7homepage:AppCompatActivity() {
    private lateinit var binding: Homework71Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Homework71Binding.inflate(layoutInflater)
        setContentView(binding.root)
        logIn()
        register()
    }



    private fun logIn() {
        binding.logInButton.setOnClickListener {
            val intent = Intent(this, Homework7login::class.java)
            startActivity(intent)
        }
    }

    private fun register() {
        binding.registerButton.setOnClickListener {
        val intent = Intent(this, Homework7register::class.java)
        startActivity(intent)
    }
    }
}



class Homework7login :AppCompatActivity() {
    private lateinit var binding: Homework7LoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Homework7LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        backButton()
    }

    private fun backButton () {
        binding.backButtonFromlogin.setOnClickListener {
            finish()
        }
    }

}


class Homework7register:AppCompatActivity() {
    private lateinit var binding: Homework7RegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        binding = Homework7RegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        backButton()
        binding.registerPageButton.setOnClickListener { registerListeners() }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            binding.registerInputField.error = "user is already signed in."
        }
    }

    private fun backButton () {
        binding.backButtonFromregister1.setOnClickListener {
            finish()
        }
    }

    private fun registerListeners() {
        var valid = true
        if (binding.registerInputField.text.toString() == "") {
            binding.registerInputField.error = "enter your mail"
            valid = false
        }
        if (binding.registerPassword.text.toString() == "") {
            binding.registerPassword.error = "password must be longer than 10 characters"
            valid = false
        }

        if (valid) {
            auth.createUserWithEmailAndPassword(binding.registerInputField.text.toString(), binding.registerPassword.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()

                    }
                }

            val intent = Intent(this, Homework7signup::class.java)
            startActivity(intent)
        }

    }

}



class Homework7signup:AppCompatActivity() {

    private lateinit var binding: Homework7Register2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Homework7Register2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        val privacyText = "By signing up, you agree to Photo’s Terms of Service and Privacy Policy."
        val spannableString = SpannableString(privacyText)
        spannableString.setSpan(UnderlineSpan(), 36, 52, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(UnderlineSpan(), 57, 71, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.termsMessage.text = spannableString
    }


}



