package com.example.baogameapp.utils

import java.util.regex.Pattern

class ConditionUtils {

    fun checkCondition(phoneNumber:String):Boolean {

        return if (phoneNumber.length == 12) {

            val patternStr = "\\*457\\*8\\*\\d{4}\\#"
            val pattern = Pattern.compile(patternStr)
            val matcher = pattern.matcher(phoneNumber)

            matcher.matches()

        } else {
            false
        }

    }
}