package com.teliacompany.hackathon.birthday.controllers

import com.teliacompany.hackathon.birthday.model.CalcResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import java.time.LocalDate

@RestController
class BirthdayController {

    private val calcUrl = "http://localhost:8081/birthtimeunitcalc/"
    private val insultUrl = "http://localhost:8082/insult/"

    @GetMapping("/{birthDayInput}")
    fun test(@PathVariable birthDayInput: String): String {
        val birthDay = LocalDate.parse(birthDayInput)

        val calc = RestTemplate().getForObject<CalcResult>(calcUrl + birthDay)
        val insult = RestTemplate().getForObject<String>(insultUrl + birthDay)

        return "On " + calc?.dateOfEvent +
                " you will be "+ calc?.number +
                " " + calc?.timeUnit?.name?.toLowerCase() + "s" +
                ", " + insult
    }

}