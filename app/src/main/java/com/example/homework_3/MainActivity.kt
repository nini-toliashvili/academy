package com.example.homework_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homeworks.converterToEnglish
import com.example.homeworks.numToText


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val numToConvert: EditText = findViewById(R.id.number_input)
        val convertButton: Button = findViewById(R.id.convert)
        val showText: TextView = findViewById(R.id.show_text)
        val checkbox: CheckBox = findViewById(R.id.checkbox)


        convertButton.setOnClickListener {
            //following isEmpty check is gpt suggestion, not quite understand what it does or what toast is
            if (numToConvert.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show()
            }
            if (checkbox.isChecked) {
                val tempString: String = numToConvert.text.toString()
                val number: Int = tempString.toInt()
                showText.text = converterToEnglish(number)
            }
            else {
                val tempString: String = numToConvert.text.toString()
                val number: Int = tempString.toInt()

                showText.text = numToText(number)
            }
        }

    }
}