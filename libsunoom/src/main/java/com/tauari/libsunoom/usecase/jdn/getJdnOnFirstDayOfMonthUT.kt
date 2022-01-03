package com.tauari.libsunoom.usecase.jdn

import com.tauari.libsunoom.domain.GregorianDate

fun getJdnOnFirstDayOfMonthUT(gregorianDate: GregorianDate): Double {
    val jdnOfGivenDateAt12AmUt = getJdnAt12AmUT(gregorianDate.dayOfMonth, gregorianDate.month, gregorianDate.year)
    val k = countMonthsFrom1Jan1900UT(jdnOfGivenDateAt12AmUt * 1.0)
    var result = getJdnOnNewMoonDay(k + 1)
    if(result > jdnOfGivenDateAt12AmUt) {
        result = getJdnOnNewMoonDay(k)
    }
    return result
}