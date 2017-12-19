package com.teliacompany.hackathon.birthday.model

import java.time.temporal.ChronoUnit

enum class TimeUnitBtu(val unit: ChronoUnit, val lowestMod: Int) {
    SECOND(ChronoUnit.SECONDS, 10_000_000),
    MINUTE(ChronoUnit.MINUTES, 1_000_000),
    HOUR(ChronoUnit.HOURS, 10_000),
    DAY(ChronoUnit.DAYS, 1_000),
    WEEK(ChronoUnit.WEEKS, 100),
    MONTH(ChronoUnit.MONTHS, 10),
    YEAR(ChronoUnit.YEARS, 1);
}