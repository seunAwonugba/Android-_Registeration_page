package com.raywenderlich.timefighter.registeration_assignment

import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ValidationTest{
    /**
     * NOTE we don't need to get the instance of the validation class because the class is an object
     * class and by default its and object and a class at the same time
     */


    /**
     * using the truth library
     */
    @Test
    fun validateEmptyNameTest(){
        assertThat(Validation.validateNameEmpty("")).isTrue()
    }

    @Test
    fun validateEmailContainsTest(){
        assertThat(Validation.validateEmailContains( "seunawonugbagmailcom")).isTrue()
    }

    @Test
    fun validateEmailEmptyTest(){
        assertThat(Validation.validateEmailEmpty("")).isTrue()
    }

    @Test
    fun validateNumberEmptyTest(){
        assertThat(Validation.validateNumberEmpty("")).isTrue()
    }

    @Test
    fun validatePhoneNumberDoesNotStartsWithTest(){
        assertThat(Validation.validatePhoneNumberDoesNotStartWith("0808037521")).isFalse()
    }

    /**
     * Note sample phone number passed is more than 10 thats why the test passed
     */
    @Test
    fun validateNumberLengthTest(){
        assertThat(Validation.validateNumberLength("08080375217")).isTrue()
    }

    @Test
    fun selectGenderFunctionTest(){
        assertThat(Validation.selectGenderFunction("Gender")).isTrue()
    }
}