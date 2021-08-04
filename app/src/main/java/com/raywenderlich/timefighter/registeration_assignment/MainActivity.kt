package com.raywenderlich.timefighter.registeration_assignment

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern.compile

class MainActivity : AppCompatActivity() {
    /**
     *instance of my views, and also an instance of values user imputes in each input field so i can
     * hold the type of value users input also
     */
    private lateinit var instanceOfFullName : com.google.android.material.textfield.TextInputEditText
    private lateinit var instanceOfEmail : com.google.android.material.textfield.TextInputEditText
    private lateinit var instanceOfPhoneNumber : com.google.android.material.textfield.TextInputEditText
    private lateinit var instanceOfButton : Button
    private lateinit var instanceOfDropDown : AutoCompleteTextView
    private lateinit var inputName:String
    private lateinit var inputEmail:String
    private lateinit var inputNumber:String
    private lateinit var selectGender :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Grab ids
         */
        instanceOfFullName = findViewById(R.id.fullNameTextId)
        instanceOfEmail = findViewById(R.id.emailTextId)
        instanceOfPhoneNumber = findViewById(R.id.phoneTextId)
        instanceOfButton = findViewById(R.id.buttonId)
        instanceOfDropDown = findViewById(R.id.genderId)

        /**
         * Create an array to hold dropdown value options, and also create an adapter for the dropdown
         * also
         */
        val genderOptions = arrayOf(" ","Female", "Male","Others")
        val arrayAdapter = ArrayAdapter(this, R.layout.gender_options, genderOptions)
        instanceOfDropDown.setText(arrayAdapter.getItem(0).toString(), false)
        instanceOfDropDown.setAdapter(arrayAdapter)

        /**
         * Set an onClickListener on the button to list to clicks and run the below function everytime
         * when it listens to the clicks
         */

        instanceOfButton.setOnClickListener {
            inputName = instanceOfFullName.text.toString().trim()
            inputEmail = instanceOfEmail.text.toString().trim()
            inputNumber = instanceOfPhoneNumber.text.toString().trim()
            selectGender = instanceOfDropDown.text.toString().trim()
            /**
             * Where Validation.validateSample(sampleVariable) == true or false, for cleaner code
             * thats why its just Validation.validateSample(sampleVariable) or
             * !Validation.validateSample(sampleVariable)
             */
            if(Validation.validateNamePattern(inputName) == false){
                instanceOfFullName.error = "Your name must not contain special characters"
            }
            else if (Validation.validateNameEmpty(inputName)){
                instanceOfFullName.error = "Kindly input your name"
            }
            else if (Validation.validateEmailEmpty(inputEmail)){
                instanceOfEmail.error = "Kindly input your email address"
            }
            else if(Validation.validateEmailContains(inputEmail)){
                instanceOfEmail.error = "Invalid email address"
            }
            else if (!Validation.validatePhoneNumberDoesNotStartWith(inputNumber)){
                instanceOfPhoneNumber.error = "Kindly input a valid nigerian phone number"
            }
            else if (Validation.validateNumberEmpty(inputNumber)){
                instanceOfPhoneNumber.error = "Kindly input your phone number"
            }
            else if (Validation.validateNumberLength(inputNumber)){
                instanceOfPhoneNumber.error = "Kindly input a valid phone number"
            }
            else if (Validation.selectGenderFunction(selectGender)){
                instanceOfDropDown.error = "Kindly select your gender"
            }
            else{
                /**
                 * If those conditions dont run, run this instead i.e upon onClick
                 * proceed to creating and intent and place on standby values u want to put inside
                 * the net activity
                 */
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("EXTRA_FULLNAME", inputName)
                intent.putExtra("EXTRA_EMAIL",inputEmail)
                intent.putExtra("EXTRA_NUMBER", inputNumber)
                intent.putExtra("EXTRA_GENDER", selectGender)
                startActivity(intent)
            }
        }
    }
}
