package com.raywenderlich.timefighter.registeration_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var instanceOfPassedName:TextView
    lateinit var instanceOfPassedEmail:TextView
    lateinit var instanceOfPassedNumber:TextView
    lateinit var instanceOfPassedGender:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        instanceOfPassedName = findViewById(R.id.passedNameId)
        instanceOfPassedNumber = findViewById(R.id.passedNumberId)
        instanceOfPassedEmail = findViewById(R.id.passedEmailId)
        instanceOfPassedGender = findViewById(R.id.passedGenderId)


        val getFullName = intent.getStringExtra("EXTRA_FULLNAME")
        val getEmail = intent.getStringExtra("EXTRA_EMAIL")
        val getNumber = intent.getStringExtra("EXTRA_NUMBER")
        val getGenderInput = intent.getStringExtra("EXTRA_GENDER")

        instanceOfPassedName.text = "User's name: $getFullName"
        instanceOfPassedEmail.text = "Email address: $getEmail"
        instanceOfPassedNumber.text = "Phone number is +234$getNumber"
        instanceOfPassedGender.text = "Gender: $getGenderInput"

    }
}