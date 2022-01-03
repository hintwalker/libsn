package com.tauari.libsunoom.usecase.conversion

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.PairOfFirstJdnNov
import com.tauari.libsunoom.usecase.jdn.getFirstJdnInNov
import com.tauari.libsunoom.usecase.jdn.getJdnOnFirstDayOfMonthUT
import com.tauari.libsunoom.usecase.jdn.shiftJdnTo00Local

fun getPairOfFirstJdn(gregorianYear: Int, timeZoneOffset: Int): PairOfFirstJdnNov {
    var firstJdnInPrevNov = getFirstJdnInNov(gregorianYear - 1, timeZoneOffset)
    var firstJdnInCurrentNov = getFirstJdnInNov(gregorianYear, timeZoneOffset)
    // shift to 00Am
    // shift to 00Am
    firstJdnInPrevNov = shiftJdnTo00Local(firstJdnInPrevNov, timeZoneOffset)
    firstJdnInCurrentNov = shiftJdnTo00Local(firstJdnInCurrentNov, timeZoneOffset)
    return PairOfFirstJdnNov(firstJdnInPrevNov, firstJdnInCurrentNov)
}

//fun getPairOfFirstJdn(date: GregorianDate): PairOfFirstJdnNov {
//    var firstJdnInPrevNov = getFirstJdnInNov(date.year, date.timeZoneOffset)
//    val jdnOnFirstDayOfMonthUT = getJdnOnFirstDayOfMonthUT(date)
//    var firstJdnInCurrentNov = firstJdnInPrevNov
//    if (firstJdnInPrevNov >= jdnOnFirstDayOfMonthUT) {
//        firstJdnInPrevNov = getFirstJdnInNov(date.year - 1, date.timeZoneOffset)
//    } else {
//        firstJdnInCurrentNov = getFirstJdnInNov(date.year + 1, date.timeZoneOffset)
//    }
//    // shift to 00Am
//    // shift to 00Am
//    firstJdnInPrevNov = shiftJdnTo00Local(firstJdnInPrevNov, date.timeZoneOffset)
//    firstJdnInCurrentNov = shiftJdnTo00Local(firstJdnInCurrentNov, date.timeZoneOffset)
//    return PairOfFirstJdnNov(firstJdnInPrevNov, firstJdnInCurrentNov)
//}