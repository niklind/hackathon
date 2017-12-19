package com.teliacompany.hackathon.birthday.controllers

import com.teliacompany.hackathon.birthday.models.calc.CalcResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.time.LocalDate

@RestController
class BirthdayController {

    private val calcUrl = "http://localhost:8081/birthtimeunitcalc/"

    @GetMapping("/{birthDayInput}")
    fun test(@PathVariable birthDayInput: String): String {
        val birthDay = LocalDate.parse(birthDayInput)

        val result = RestTemplate().getForObject<CalcResult>(calcUrl + birthDay)

        return "On " + result?.dateOfEvent.toString() +
                " you will be "+ result?.number +
                " " + result?.timeUnit?.name
    }

}