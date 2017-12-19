package com.teliacompany.hackathon.birthday

import com.teliacompany.hackathon.birthday.model.TimeUnitBtu
import org.junit.Assert
import org.junit.Test
import java.time.LocalDateTime
import java.time.Month

class BirthUnitCalculatorTest {

    @Test
    fun getCalc() {
        val cr = BirthUnitCalculator().getCalc(LocalDateTime.of(2002,Month.JANUARY,1,0,0),
                LocalDateTime.of(2017,Month.FEBRUARY,1,0,0))

        Assert.assertEquals(TimeUnitBtu.MINUTE, cr.timeUnit);
        Assert.assertEquals(8000000, cr.number);
    }

    @Test
    fun getCalcInvalid() {
        val cr = BirthUnitCalculator().getCalc(LocalDateTime.of(1960,Month.JANUARY,1,0,0),
                LocalDateTime.of(2017,Month.DECEMBER,19,16,0))

        Assert.assertEquals(TimeUnitBtu.MONTH, cr.timeUnit)
        Assert.assertEquals(700, cr.number)
        Assert.assertEquals(1, cr.dateOfEvent.dayOfMonth)
    }
}