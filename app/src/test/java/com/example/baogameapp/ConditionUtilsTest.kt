package com.example.baogameapp

import com.example.baogameapp.utils.ConditionUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ConditionUtilsTest {

    lateinit var mConditionUtils: ConditionUtils

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mConditionUtils = ConditionUtils()
    }

    @Test
    fun additionIsCorrect() {
        val phone = "*457*8*0000#"
        Assert.assertEquals(true, mConditionUtils.checkCondition(phone))
    }

    @Test
    fun additionIsIncorrect() {
        val phone = "*457*8*0000"
        Assert.assertEquals(false, mConditionUtils.checkCondition(phone))
    }
}