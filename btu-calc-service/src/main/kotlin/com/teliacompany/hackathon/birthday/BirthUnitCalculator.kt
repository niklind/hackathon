package com.teliacompany.hackathon.birthday

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.util.concurrent.TimeUnit

@RestController
class BirthUnitCalculator {

    data class CalcResult(val timeUnit: TimeUnit, val number: Long,  val dateOfEvent: LocalDate)

    @GetMapping("/birthtimeunitcalc/{btuDate}")
    fun calculateBirthTimeUnit(@PathVariable(value = "btuDate") btuDate: String): CalcResult {

        return CalcResult(TimeUnit.DAYS, 18000, LocalDate.parse(btuDate))
    }

    fun calculateWeeks(date: LocalDate): Int {
        val current = LocalDateTime.now()

        return 0;
    }

}