package com.example.homeworks

fun numToText(x:Int) :String? {
    if (x < 1 || x>1000) return "invalid input"
    var formatedString:String? = ""
    //for x that is between 20 and 100 and has
    if (x>= 20 && x%20!= 0 && x<100) {
        formatedString+= mapOfNumbers[(x/20*20)] + "და" + mapOfNumbers[(x%20)]}

    // for (20,40,60,80,100)
    if ( x>19 && x%20==0 && x<=100) formatedString += mapOfNumbers[(x/20*20)] + "ი"

    //for x between 100 and 200
    if (x in 101..199) {
        formatedString += if (x<120) mapOfNumbers[100] + mapOfNumbers[x%100]
        else {
            if (x%20 == 0) mapOfNumbers[100] + mapOfNumbers[((x-100)/20*20)] + "ი"
            else mapOfNumbers[100] + mapOfNumbers[((x-100)/20*20)] + "და" + mapOfNumbers[(x%20)]
        }
    }

    if (x in 200..999) {
        val temp:String? = if (mapOfNumbers[x/100]?.get((mapOfNumbers[x/100]?.length)?.minus(1) ?: 0)  =='ი') {
            mapOfNumbers[x/100]?.dropLast(1)
        } else mapOfNumbers[x/100]


        formatedString+= if (x%100 == 0) temp + mapOfNumbers[100] + "ი"
        else { if (x - (x/100*100 ) < 20) temp + mapOfNumbers[100] + mapOfNumbers[x%100]
        else {
            if (x%20 == 0) temp + mapOfNumbers[100] + mapOfNumbers[((x-100)/20*20)] + "ი"
            else temp + mapOfNumbers[100] + mapOfNumbers[((x-(x/100*100 ))/20*20)] + "და" + mapOfNumbers[(x%20)]
        }

        }
    }

    if (formatedString == "") return mapOfNumbers[x]



    return formatedString
}


fun converterToEnglish(x:Int) :String? {
    var formedString:String? = ""
    if (x in 21..99) formedString += mapOfNumEng[x%10*10]+ mapOfNumEng[x%10]
    else if (x in 100..999)
        formedString += if (x - (x/100*100 ) < 20) mapOfNumEng[x/100] + mapOfNumEng[100] + mapOfNumEng[x-(x/100*100)]
        else mapOfNumEng[x/100] + mapOfNumEng[100] + mapOfNumEng[x-(x/100*100) - (x%10)] + mapOfNumEng[x%10]

    if (formedString == "") formedString = mapOfNumEng[x]

    return formedString
}
