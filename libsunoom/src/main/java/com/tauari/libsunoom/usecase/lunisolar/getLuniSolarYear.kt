package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.domain.*
import com.tauari.libsunoom.usecase.conversion.*
import com.tauari.libsunoom.usecase.gregorian.getGregorianDateFromJdnLocal
import com.tauari.libsunoom.usecase.sun.getSunLongitudeFromJdn
import com.tauari.libsunoom.usecase.sun.isMajorTermInside

fun getLuniSolarYear(gregorianYear: Int, timeZoneOffset: Int): LuniSolarYear {
    val pairOfFirstJdnNov = getPairOfFirstJdn(gregorianYear, timeZoneOffset)
    val countDays = pairOfFirstJdnNov.current - pairOfFirstJdnNov.previous
    var countMonths = 13
    if(countDays > 365) {
        countMonths = 14
    }
    val months: ArrayList<LuniSolarMonth> = arrayListOf()


    val listOfJdnNov = _getListOfFirstJdnPerMonth(countMonths, pairOfFirstJdnNov, timeZoneOffset)
    listOfJdnNov.forEachIndexed { index, jdn ->
        months.add(
            LuniSolarMonth(
                index,
                getGregorianDateFromJdnLocal(
                    jdn, timeZoneOffset
                ),
                _getMonthValueFromIndex(index), false, jdn
            )
        )
    }
    var leapMonthIndex = -1
    if(countMonths == 14) {
        var i = 0
        var foundLeapMonth = false
        for(i in 0 until(14)) {
            if(foundLeapMonth) {
                months[i].value = _modifyMonthValueIfLeapFound(i)
                continue
            }
            if(i < 13) {
                val sunLong = getSunLongitudeFromJdn(months[i].jdnOfFirstDate)
                val nextSunLong = getSunLongitudeFromJdn(months[i+1].jdnOfFirstDate)
                val isMajorInside = isMajorTermInside(0, nextSunLong, sunLong)
                if(!isMajorInside) {
                    foundLeapMonth = true
                    months[i].value = _modifyMonthValueIfLeapFound(i)
                    months[i].isLeap = true
                    leapMonthIndex = i
                }
            }


        }
    }
    return LuniSolarYear(months, leapMonthIndex, timeZoneOffset)
}

private fun findGregorianYear(date: LuniSolarDate): Int {
    return if(date.month < 11) {
        date.year;
    } else {
        date.year + 1;
    }
}

private fun fromPairOfFirstJdnNov(pairOfFirstJdnNov: PairOfFirstJdnNov, timeZoneOffset: Int): LuniSolarYear {
    val countMonths = if(isYearLeap(pairOfFirstJdnNov, timeZoneOffset)) {
        14
    } else { 13 }
    val listOfFirstJdnPerMonth = getListOfFirstJdnPerMonth(countMonths, pairOfFirstJdnNov, timeZoneOffset)
    val (months, leapMonthIndex) = getLuniSolarMonths(listOfFirstJdnPerMonth, pairOfFirstJdnNov, timeZoneOffset)
    return LuniSolarYear(months, leapMonthIndex, timeZoneOffset)
}

private fun isYearLeap(pairOfFirstJdnNov: PairOfFirstJdnNov, timeZoneOffset: Int): Boolean {
    val currentGregorianDate = getGregorianDateFromJdnLocal(pairOfFirstJdnNov.current, timeZoneOffset)
    return isLuniSolarYearLeap(currentGregorianDate.year)
//    return pairOfFirstJdnNov.current - pairOfFirstJdnNov.previous > 366.0;
}

fun getLuniSolarYear(date: GregorianDate): LuniSolarYear {
    //Find couple of first jdnOfNov in prev lunar year and this year
    //to check if this lunisolar year is leap
    val pairOfFirstJdnNov = getPairOfFirstJdn(date.year, date.timeZoneOffset)
    return fromPairOfFirstJdnNov(pairOfFirstJdnNov, date.timeZoneOffset)
}