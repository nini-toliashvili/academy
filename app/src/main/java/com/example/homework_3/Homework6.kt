package com.example.homework_3

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_3.databinding.Homework6Binding


class Homework6:AppCompatActivity() {

    private lateinit var binding: Homework6Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = Homework6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.locationName.setText(getString(R.string.andes_mountain))
        binding.location.setText(getString(R.string.south_america))
        binding.price.setText(getString(R.string.price))
        binding.priceInDollars.setText(R.string.p230)
        binding.content.setText(R.string.content)
        binding.content.isFocusable = true
        binding.content.isFocusableInTouchMode = true

    }
}