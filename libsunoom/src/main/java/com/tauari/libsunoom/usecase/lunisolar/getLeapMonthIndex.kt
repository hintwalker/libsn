package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.domain.LuniSolarYear

fun getLeapMonthValue(date: GregorianDate): Int {
    val lunarYear = getLuniSolarYear(date)
    return getLeapMonthValue(lunarYear)

}

fun getLeapMonthValue(date: LuniSolarDate): Int {
    val gregYear = if(date.month >= 11) date.year + 1 else date.year
    val lunarYear = getLuniSolarYear(gregYear, date.timeZoneOffset)
    return getLeapMonthValue(lunarYear)
//    return if(lunarYear.leapMonthIndex > 2) getMonthValueFromIndex(lunarYear.leapMonthIndex) else -1
}

private fun getLeapMonthValue(lunarYear: LuniSolarYear): Int {
    return if(lunarYear.leapMonthIndex >= 0) lunarYear.getLeapMonth()!!.value else -1
}