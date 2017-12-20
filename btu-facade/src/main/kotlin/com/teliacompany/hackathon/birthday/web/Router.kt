package com.teliacompany.hackathon.birthday.web

import com.teliacompany.hackathon.birthday.controllers.BirthdayController
import com.teliacompany.hackathon.birthday.controllers.HtmlController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

@Configuration
class Router(private val birthDayController: BirthdayController,
             private val htmlController: HtmlController) {

    @Bean
    fun appRouter() = router {
        GET("/birthdayInsult/{birthDayInput}", birthDayController::birthdayInsult)
        accept(MediaType.TEXT_HTML).nest {
            GET("/", htmlController::form)
        }
    }

}