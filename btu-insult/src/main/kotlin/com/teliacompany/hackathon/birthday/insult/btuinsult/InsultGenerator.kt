package com.teliacompany.hackathon.birthday.insult.btuinsult

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.concurrent.TimeUnit
import com.teliacompany.hackathon.birthday.insult.btuinsult.util.generateInsult



@RestController
class InsultGenerator {

    @GetMapping("/insult/{btuDate}")
    fun generateInsult(@PathVariable(value = "btuDate") btuDate: String): String {

        val current = LocalDate.now()
        val date = LocalDate.parse(btuDate)
        val ageInYears = current.year - date.year

        return generateInsult(ageInYears.toLong())
    }
}