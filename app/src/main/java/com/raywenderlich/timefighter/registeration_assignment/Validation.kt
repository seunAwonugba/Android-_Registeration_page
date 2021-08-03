package com.raywenderlich.timefighter.registeration_assignment

/**
 * Validation object class, it holds every function that runs in the main activity and because its
 * an object class, i can call it directly inside another class without creating an instance of it
 * and there by making use of the functions created in it
 */
object Validation {
    fun validateNameEmpty(inputName:String):Boolean{
        if(inputName.isEmpty()){
            return true
        }
        return false
    }

    fun validateEmailContains(inputEmail: String):Boolean{
        if (!inputEmail.contains("@") || !inputEmail.contains(".")){
            return true
        }
        return false
    }

    fun validateEmailEmpty(inputEmail:String):Boolean{
        if (inputEmail.isEmpty()){
            return true
        }
        return false
    }

    fun validateNumberEmpty(inputNumber:String):Boolean{
        if(inputNumber.isEmpty()){
            return true
        }
        return false
    }

    fun validateNumberLength(inputNumber: String):Boolean{
        if(inputNumber.length !=10){
            return true
        }
        return false
    }

    fun selectGenderFunction(selectGender:String):Boolean{
        if (selectGender == "Gender"){
            return true
        }
        return false
    }
}