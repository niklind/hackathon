package com.teliacompany.hackathon.birthday.controllers

import com.teliacompany.hackathon.birthday.model.CalcResult
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.reactive.function.BodyInserters.fromObject
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

        val calc = RestTemplate().getForObject<CalcResult>(calcUrl + birthDay)
        val insult = RestTemplate().getForObject<String>(insultUrl + birthDay)

        return ServerResponse.ok().body(fromObject("On " + calc?.dateOfEvent +
                " you will be "+ calc?.number +
                " " + calc?.timeUnit?.name?.toLowerCase() + "s" +
                ". " + insult + "!"))
    }

}