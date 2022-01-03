package com.tauari.libsunoom.usecase.conversion

import com.tauari.libsunoom.domain.PairOfFirstJdnNov
import com.tauari.libsunoom.usecase.jdn.countMonthsFrom1Jan1900UT
import com.tauari.libsunoom.usecase.jdn.getJdnOnNewMoonDay
import com.tauari.libsunoom.usecase.jdn.shiftJdnTo00Local

fun getListOfFirstJdnPerMonth(countMonths: Int, pairOfJdnNov: PairOfFirstJdnNov, timeZoneOffset: Int): List<Double> {
    val result = arrayListOf<Double>()
    result.add(pairOfJdnNov.previous)
    // WARN: I dont know why must plus 1 in javascript. in kotlin app I didn't.
    val k0 = countMonthsFrom1Jan1900UT(pairOfJdnNov.previous) + 1
    for (index in 1 until(countMonths - 1) ) {
        val jdnNewMoon = getJdnOnNewMoonDay(k0 + index)
        val jdnAt00 = shiftJdnTo00Local(jdnNewMoon, timeZoneOffset)
        result.add(jdnAt00)
    }
    result.add(pairOfJdnNov.current)
    return result
}