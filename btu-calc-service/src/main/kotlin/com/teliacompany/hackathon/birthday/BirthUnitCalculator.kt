package com.teliacompany.hackathon.birthday

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.concurrent.TimeUnit

@RestController
class BirthUnitCalculator {

    data class CalcResult(val timeUnit: TimeUnit, val number: Long,  val dateOfEvent: LocalDate)

    @GetMapping("/birthtimeunitcalc/{btuDate}")
    fun calculateBirthTimeUnit(@PathVariable(value = "btuDate") btuDate: String): CalcResult {

        return CalcResult(TimeUnit.DAYS, getAge(LocalDate.parse(btuDate)), LocalDate.parse(btuDate))
    }

    fun getAge(birthdate: LocalDate): Long {
        val current = LocalDate.now()

        val ageInYears = current.year - birthdate.year

        val ageInDays = ageInYears * 360

        return ageInDays.toLong()
    }

}