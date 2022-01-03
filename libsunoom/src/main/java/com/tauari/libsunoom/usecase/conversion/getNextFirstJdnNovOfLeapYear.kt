package com.tauari.libsunoom.usecase.conversion

import com.tauari.libsunoom.usecase.jdn.countMonthsFrom1Jan1900UT
import com.tauari.libsunoom.usecase.jdn.getJdnOnNewMoonDay
import com.tauari.libsunoom.usecase.jdn.shiftJdnTo00Local

fun getNextFirstJdnNovOfLeapYear(prevFirstJdnNov: Double, timeZoneOffset: Int): Double {
    val k0 = countMonthsFrom1Jan1900UT(prevFirstJdnNov) + 1
    val jdnNewMoon = getJdnOnNewMoonDay(k0 + 13)
    return shiftJdnTo00Local(jdnNewMoon, timeZoneOffset)
}