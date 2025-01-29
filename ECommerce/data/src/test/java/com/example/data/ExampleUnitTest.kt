package com.example.data

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println("test addition")
        assertEquals(4, 2 + 2)
    }
    @Test
    fun subtraction_isCorrect() {
        println("test addition")
        assertEquals(0, 2 - 2)
    }


    companion object {
        @JvmStatic
        @BeforeAll
        fun testBefore(): Unit {
            println("test before")
        }
    }


    @After
    fun testAfter()
    {
        println("test after")
    }
}