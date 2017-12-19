package com.teliacompany.hackathon.birthday.insult.btuinsult.util

fun generateInsult(age : Long) : String {

    var insult = ""
    if (age < 0)
        insult = "You are not born yet - access denied"
    if (age < 2)
        insult = "You diaper pooper"
    else if (age < 10)
        insult = "You can move to Ireland"
    else if (age < 20)
        insult = "You annoying teenager"
    else if (age < 40)
        insult = "Your life is over..."
    else if (age < 50)
        insult = "How is your midlife crisis doing?"
    else if (age < 70)
        insult = "You are really - I mean really - old"
    else
        insult = "I do not know what to say"

    return insult
}
