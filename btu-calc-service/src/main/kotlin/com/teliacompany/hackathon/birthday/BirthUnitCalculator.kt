package com.teliacompany.hackathon.birthday

import com.teliacompany.hackathon.birthday.model.CalcResult
import com.teliacompany.hackathon.birthday.model.TimeUnitBtu
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.util.*

@RestController
class BirthUnitCalculator {

    @GetMapping("/birthtimeunitcalc/{btuDate}")
    fun calculateBirthTimeUnit(@PathVariable(value = "btuDate") btuDate: String): CalcResult {

        return getCalc(LocalDate.parse(btuDate).atTime(0,0), LocalDateTime.now())
    }

    fun getCalc(btuDate: LocalDateTime, now: LocalDateTime): CalcResult {

        var maxRating = 0
        val allResults = ArrayList<RatingAndResult>()
        for (tu: TimeUnitBtu in TimeUnitBtu.values()) {
            val numberTuFromNow = tu.unit.between(btuDate, now)
            val toSub = numberTuFromNow % tu.lowestMod
            val backToInteresting = now.minus(toSub, tu.unit)
            for (idx: Int in 1..3) {
                val nextInteresting = backToInteresting.plus(idx.toLong() * tu.lowestMod, tu.unit)
                val numberTu = tu.unit.between(btuDate, nextInteresting)


                val calcResult = CalcResult(tu, numberTu, btuDate.plus(numberTu, tu.unit).toLocalDate())
                val rating = rating(numberTu)
                maxRating = Math.max(rating, maxRating)

                allResults.add(RatingAndResult(calcResult, rating))
//                println("" + rating + ". " + tu.toString() + ". numberTu: " + numberTu + ". Idx: " + idx + ". CalcResult: " + calcResult)
            }
        }

        var numMs = Long.MAX_VALUE
        var resultToReturn = CalcResult(TimeUnitBtu.DAY, 78, LocalDate.of(1987, Month.FEBRUARY, 4))
        for (res: RatingAndResult in allResults) {
            if (maxRating == res.rating) {

                if (numMs > res.calcResult.dateOfEvent.toEpochDay()) {
                    numMs = res.calcResult.dateOfEvent.toEpochDay()
                    resultToReturn = res.calcResult
                }

                //println("" + maxRating + ". " + res.calcResult)
            }
        }
        //println(resultToReturn)
        return resultToReturn
    }

    fun rating(num: Number): Int {
        return 11 - num.toInt().toString().replace("0", "").length
    }

    fun numDigs(obj: Number): Int {
        return obj.toInt().toString().length
    }

    data class RatingAndResult(val calcResult: CalcResult, val rating: Int)
}