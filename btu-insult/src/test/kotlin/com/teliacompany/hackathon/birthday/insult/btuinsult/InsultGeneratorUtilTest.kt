package com.teliacompany.hackathon.birthday.insult.btuinsult

import org.junit.Assert.assertEquals
import org.junit.Test
import com.teliacompany.hackathon.birthday.insult.btuinsult.util.generateInsult

class InsultGeneratorUtilTest {
    @Test
    fun testDiaper() {
        assertEquals(generateInsult(1), "You diaper pooper")
    }

    @Test
    fun testKid() {
        assertEquals(generateInsult(5), "You can move to Ireland")
    }

    @Test
    fun testTeenager() {
        assertEquals(generateInsult(15), "You annoying teenager")
    }

    @Test
    fun testAdult() {
        assertEquals(generateInsult(35), "Your life is over...")
    }

    @Test
    fun testMidlifeCrisis() {
        assertEquals(generateInsult(45), "How is your midlife crisis doing?")
    }

    @Test
    fun testReallyOld() {
        assertEquals(generateInsult(65), "You are really - I mean really - old")
    }

    @Test
    fun testElse() {
        assertEquals(generateInsult(85), "I do not know what to say")
    }

    @Test
    fun testLessThanZero() {
        assertEquals(generateInsult(-2), "You are not born yet - access denied")
    }











}