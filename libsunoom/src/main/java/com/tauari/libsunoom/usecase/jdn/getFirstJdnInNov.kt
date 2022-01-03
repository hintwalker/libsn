package com.tauari.libsunoom.usecase.jdn

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.usecase.sun.getSunLongitudeFromJdn
import kotlin.math.PI

fun getFirstJdnInNov(gregorianYear: Int, timeZoneOffset: Int): Double {
    val pairOfJdnNewMoon = jdnOfNewMoonLocal(gregorianYear, timeZoneOffset)
    val sunLongitude = getSunLongitudeFromJdn(pairOfJdnNewMoon.second)
    if(mustMoveBackWard(sunLongitude)) {
        return getJdnOnNewMoonDay(pairOfJdnNewMoon.first - 1)
    }
    return pairOfJdnNewMoon.second
}

private fun jdnOfNewMoonLocal(year: Int, timeZoneOffset: Int): Pair<Int, Double> {
    val jdnIn31Dec = getJdnAt00Local(GregorianDate(31, 12, year, timeZoneOffset))
    val monthsNumOffset = countMonthsFrom1Jan1900UT(jdnIn31Dec)
    val jdnNewMoon = getJdnOnNewMoonDay(monthsNumOffset)
    return monthsNumOffset to jdnNewMoon
}

private fun mustMoveBackWard(sunLongitude: Double): Boolean {
    val checkingValue = 3.0 * PI / 2.0
    val delta = sunLongitude - checkingValue
    return (delta) > 0.01
}