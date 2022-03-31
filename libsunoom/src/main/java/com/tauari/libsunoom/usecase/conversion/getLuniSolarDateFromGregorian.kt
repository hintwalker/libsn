package com.tauari.libsunoom.usecase.conversion

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.domain.PairOfFirstJdnNov
import com.tauari.libsunoom.domain.SunoomTime
import com.tauari.libsunoom.usecase.gregorian.nextGregorianDate
import com.tauari.libsunoom.usecase.jdn.countMonthsFrom1Jan1900UT
import com.tauari.libsunoom.usecase.jdn.getJdnAt00Local
import com.tauari.libsunoom.usecase.jdn.getJdnOnNewMoonDay
import com.tauari.libsunoom.usecase.jdn.shiftJdnTo00Local
import com.tauari.libsunoom.usecase.lunisolar.getLuniSolarYear
import kotlin.math.floor

fun getLuniSolarDateFromGregorian(date: GregorianDate, time: SunoomTime): LuniSolarDate? {
    return when (time.hour) {
        in 0..22 -> getLuniSolarDateFromGregorian(date)
        23 -> {
            val nextDay = nextGregorianDate(date)
            getLuniSolarDateFromGregorian(nextDay)
        }
        else -> null
    }
}
//    if(time.hour in 0..22) {
//        return getLuniSolarDateFromGregorian(date)
//    }
//    if(time.hour == 23) {
//        val nextDay = nextGregorianDate(date)
//        return getLuniSolarDateFromGregorian(nextDay)
//    } else {
//        return null
//    }

fun getLuniSolarDateFromGregorian(date: GregorianDate): LuniSolarDate? {
    var resultYear = date.year
    var luniSolarYear = getLuniSolarYear(date.year, date.timeZoneOffset)
    val lastJdnNov = luniSolarYear.months.last().jdnOfFirstDate
    val jdnOfGiveDateLocal = getJdnAt00Local(date)
    if(jdnOfGiveDateLocal >= lastJdnNov) {
        resultYear = date.year + 1
        luniSolarYear = getLuniSolarYear(date.year + 1, date.timeZoneOffset)
    }
    var i = luniSolarYear.countMonths() - 1
    while(jdnOfGiveDateLocal < luniSolarYear.months[i].jdnOfFirstDate) {
        i --
    }
    val resultMonth = luniSolarYear.months[i]
    val resultDay = (jdnOfGiveDateLocal - resultMonth.jdnOfFirstDate).toInt() + 1
    if(resultMonth.value >= 11) {
        resultYear --
    }
    return LuniSolarDate(
        resultDay,
        resultMonth.value,
        resultYear,
        resultMonth.isLeap,
        date.timeZoneOffset
    )
}

//fun _getLuniSolarYear(gregorianYear: Int, timeZoneOffset: Int): LuniSolarYear {
//    val pairOfFirstJdnNov = _getPairOfFirstJdnNov(gregorianYear, timeZoneOffset)
//    val countDays = pairOfFirstJdnNov.current - pairOfFirstJdnNov.previous
//    var countMonths = 13
//    if(countDays > 365) {
//        countMonths = 14
//    }
//    val months: ArrayList<LuniSolarMonth> = arrayListOf()
//
//
//    val listOfJdnNov = _getListOfFirstJdnPerMonth(countMonths, pairOfFirstJdnNov, timeZoneOffset)
//    listOfJdnNov.forEachIndexed { index, jdn ->
//        months.add(
//            LuniSolarMonth(
//                index,
//                getGregorianDateFromJdnLocal(
//                    jdn, timeZoneOffset
//                ),
//                _getMonthValueFromIndex(index), false, jdn
//            )
//        )
//    }
//    var leapMonthIndex = -1
//    if(countMonths == 14) {
//        var i = 0
//        var foundLeapMonth = false
//        for(i in 0 until(14)) {
//            if(foundLeapMonth) {
//                months[i].value = _modifyMonthValueIfLeapFound(i)
//                continue
//            }
//            if(i < 13) {
//                val sunLong = getSunLongitudeFromJdn(months[i].jdnOfFirstDate)
//                val nextSunLong = getSunLongitudeFromJdn(months[i+1].jdnOfFirstDate)
//                val isMajorInside = isMajorTermInside(0, nextSunLong, sunLong)
//                if(!isMajorInside) {
//                    foundLeapMonth = true
//                    months[i].value = _modifyMonthValueIfLeapFound(i)
//                    months[i].isLeap = true
//                    leapMonthIndex = i
//                }
//            }
//
//
//        }
//    }
//    return LuniSolarYear(months, leapMonthIndex, timeZoneOffset)
//}

//fun _getPairOfFirstJdnNov(gregorianYear: Int, timeZoneOffset: Int): PairOfFirstJdnNov {
//    var firstJdnInPrevNov = getFirstJdnInNov(gregorianYear - 1, timeZoneOffset)
//    var firstJdnInCurrentNov = getFirstJdnInNov(gregorianYear, timeZoneOffset)
//
////    val jdnOnFirstDayOfMonthUT = getJdnOnFirstDayOfMonthUT(date)
////    var firstJdnInCurrentNov = firstJdnInPrevNov
////    if (firstJdnInPrevNov >= jdnOnFirstDayOfMonthUT) {
////        firstJdnInPrevNov = getFirstJdnInNov(gregorianYear - 1, timeZoneOffset)
////    } else {
////        firstJdnInCurrentNov = getFirstJdnInNov(gregorianYear + 1, timeZoneOffset)
////    }
//    // shift to 00Am
//    // shift to 00Am
//    firstJdnInPrevNov = shiftJdnTo00Local(firstJdnInPrevNov, timeZoneOffset)
//    firstJdnInCurrentNov = shiftJdnTo00Local(firstJdnInCurrentNov, timeZoneOffset)
//    return PairOfFirstJdnNov(firstJdnInPrevNov, firstJdnInCurrentNov)
//}

fun _getListOfFirstJdnPerMonth(countMonths: Int, pairOfJdnNov: PairOfFirstJdnNov, timeZoneOffset: Int): List<Double> {
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

fun _getMonthValueFromIndex(index: Int): Int {
    return _mod(index + 11, 12)
}

fun _modifyMonthValueIfLeapFound(index: Int): Int {
    return _mod(index + 10, 12)
}
fun _mod(x: Int, y: Int): Int {
    var z = x - (y * floor(x.toDouble() / y)).toInt()
    if (z == 0) {
        z = y
    }
    return z
}

//fun getLuniSolarDateFromGregorian(date: GregorianDate): LuniSolarDate? {
//    val luniSolarYear = getLuniSolarYear(date)
//    val jdnOfGiveDateLocal = getJdnAt00Local(date)
//    var monthIndex = luniSolarYear.countMonths() - 1
//    while(monthIndex >= 0 && jdnOfGiveDateLocal < luniSolarYear.months[monthIndex].jdnOfFirstDate) {
//        monthIndex --
//        if(monthIndex < 0) {
//            return null
//        }
//    }
//    val luniSolarMonth = luniSolarYear.months[monthIndex]
//    val dayOfMonth = (jdnOfGiveDateLocal - luniSolarMonth.jdnOfFirstDate).toInt() + 1
//    var yearValue = luniSolarYear.getYearValue()
//    var limitMonthIndex = 2
////    if(luniSolarYear.leapMonthIndex == 0) {
////        limitMonthIndex = 3
////    }
//    if(monthIndex < limitMonthIndex) {
//        yearValue -= 1
//    }
//    return LuniSolarDate(
//        dayOfMonth,
//        luniSolarMonth.value,
//        yearValue,
//        luniSolarMonth.isLeap,
//        date.timeZoneOffset
//    )
//}