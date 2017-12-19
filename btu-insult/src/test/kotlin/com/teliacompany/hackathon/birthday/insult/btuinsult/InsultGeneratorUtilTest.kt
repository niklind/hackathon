package com.teliacompany.hackathon.birthday.insult.btuinsult

import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import com.teliacompany.hackathon.birthday.insult.btuinsult.util.generateInsult

class InsultGeneratorUtilTest {

    companion object {

        @JvmStatic
        @BeforeClass
        fun init() {
            println("nada")
        }

    }

    @Test
    fun testParse() {
        println(generateInsult(1))
        assertEquals(generateInsult(1), "You diaper pooper")
    }

}