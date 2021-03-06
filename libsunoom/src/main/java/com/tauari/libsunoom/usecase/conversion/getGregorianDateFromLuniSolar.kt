package com.tauari.libsunoom.usecase.conversion

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.domain.SunoomTime
import com.tauari.libsunoom.usecase.gregorian.getGregorianDateFromJdnLocal
import com.tauari.libsunoom.usecase.gregorian.nextGregorianDate
import com.tauari.libsunoom.usecase.lunisolar.getLuniSolarYear

fun getGregorianDateFromLuniSolar(date: LuniSolarDate, time: SunoomTime): GregorianDate? {
    return when(time.hour) {
        in 0..22 -> getGregorianDateFromLuniSolar(date)
        23 -> {
            getGregorianDateFromLuniSolar(date)?.let { nextGregorianDate(it, -1) }
        }
        else -> null
    }
}

fun getGregorianDateFromLuniSolar(date: LuniSolarDate): GregorianDate? {
    val gregYear = if(date.month > 10) date.year + 1 else date.year
    val luniSolarYear = getLuniSolarYear(gregYear, date.timeZoneOffset)
    val luniSolarMonth = luniSolarYear.getMonthOfDate(date)
    return if(luniSolarMonth != null) {
        val jdn = luniSolarMonth.jdnOfFirstDate + date.dayOfMonth - 1
        getGregorianDateFromJdnLocal(jdn, date.timeZoneOffset)
    } else {
        null
    }
}