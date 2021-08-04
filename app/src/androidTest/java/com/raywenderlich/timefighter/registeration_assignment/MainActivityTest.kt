package com.raywenderlich.timefighter.registeration_assignment

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest{
    private lateinit var inputNameTest: String
    private lateinit var inputEmailTest: String
    private lateinit var inputNumberTest: String
    private lateinit var selectGenderTest: String


    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        // Specify a valid string.
        inputNameTest = "Awonugba seun"
        inputEmailTest = "seunawonugba@gmail.com"
        inputNumberTest = "8080375217"
        selectGenderTest = "Male"
    }

    @Test
    fun changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.fullNameTextId)).perform(
            typeText(inputNameTest),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.emailTextId)).perform(
            typeText(inputEmailTest),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.phoneTextId)).perform(
            typeText(inputNumberTest),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.genderId)).perform(
            typeText(selectGenderTest),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.buttonId)).perform(click())
        onView(withId(R.id.passedNameId))
        onView(withId(R.id.passedEmailId))
        onView(withId(R.id.passedNumberId))
        onView(withId(R.id.passedGenderId))
    }

}