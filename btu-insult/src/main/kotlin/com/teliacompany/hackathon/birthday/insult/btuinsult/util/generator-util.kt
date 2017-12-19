package com.teliacompany.hackathon.birthday.insult.btuinsult.util

fun generateInsult(age : Long) : String {

    var insult = ""
    if (age < 2)
        insult = "You diaper pooper"
    else if (age < 10)
        insult = "You can move to Ireland"
    else if (age < 20)
        insult = "You annoying teenager"

    return insult
}
