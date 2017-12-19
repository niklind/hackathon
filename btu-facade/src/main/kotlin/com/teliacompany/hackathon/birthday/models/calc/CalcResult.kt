package com.teliacompany.hackathon.birthday.models.calc;

import java.time.LocalDate
import java.util.concurrent.TimeUnit

data class CalcResult(val timeUnit: TimeUnit = TimeUnit.SECONDS, val number: Long = 0, val dateOfEvent: LocalDate = LocalDate.now())