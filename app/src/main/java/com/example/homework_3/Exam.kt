package com.example.homework_3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_3.databinding.ExamLBinding


class Exam: AppCompatActivity() {
    private lateinit var bindiing : ExamLBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindiing = ExamLBinding.inflate(layoutInflater)
        setContentView(bindiing.root)
        val anagramList = mutableListOf<String>()

        bindiing.save.setOnClickListener {
            if (bindiing.inputAnagram.text.toString() == "") bindiing.inputAnagram.error = "field can not be empty"
            anagramList.add(bindiing.inputAnagram.text.toString())
            bindiing.inputAnagram.setText("")
        }

        bindiing.output.setOnClickListener {

            val lists = mutableListOf<MutableList<String>>()

            fun anagrams(x:MutableList<String>) { //ლოგიკა მაქვს გასამართი რაც ვერ მოვასწარი სამწუხაროდ
                val tempList = mutableListOf<String>()
                val otherList = mutableListOf<String>()
                if (x.last() == "") return;
                for (i in x.indices) {
                    if (i == x.size - 1 ) break
                    if (x[i].toSet() == x[i+1].toSet()) {

                        tempList.add(x[i])
                        tempList.add(x[i+1])
                        x[i] = ""
                        x[i+1] = ""
                    } else {
                        otherList.add(x[i])
                        x[i] = ""
                    }

                }
                lists.add(tempList)
                anagrams(otherList)

            }
            if (anagramList.isNotEmpty()) anagrams(anagramList)
            var tempString = ""
            for (item in lists) {
                tempString += item.toString() + "\n"
            }

            val newString = """
                number of anagrams : ${lists.size}
                $tempString""".trimIndent()

            bindiing.showAnagrams.text = newString
            bindiing.showAnagrams.visibility = View.VISIBLE


        }

        bindiing.clear.setOnClickListener {
            bindiing.showAnagrams.visibility = View.INVISIBLE
        }

    }
}