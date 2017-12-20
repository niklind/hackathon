package com.teliacompany.hackathon.birthday.controllers

import com.teliacompany.hackathon.birthday.model.CalcResult
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.time.LocalDate

@Component
class BirthdayController {

    private val calcUrl = "http://localhost:8081/birthtimeunitcalc/"
    private val insultUrl = "http://localhost:8082/insult/"

    fun birthdayInsult(req: ServerRequest): Mono<ServerResponse> {
        val birthDayInput = req.pathVariable("birthDayInput")
        val birthDay = LocalDate.parse(birthDayInput)

        val calc = WebClient.create(calcUrl + birthDay)
                .get()
                .retrieve()
                .bodyToMono<CalcResult>()

        val insult = WebClient.create(insultUrl + birthDay)
                .get()
                .retrieve()
                .bodyToMono<String>()

        return calc.zipWith(insult)
                .map {
                    "On " + it.t1.dateOfEvent +
                    " you will be " + it.t1.number +
                    " " + it.t1.timeUnit.name.toLowerCase() + "s." +
                    " " + it.t2 + "!"
                }
                .flatMap {
                    ServerResponse.ok().body(fromObject(it))
                }
    }

}