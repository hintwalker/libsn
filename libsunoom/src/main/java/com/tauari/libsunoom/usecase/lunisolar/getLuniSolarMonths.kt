package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.domain.LuniSolarMonth
import com.tauari.libsunoom.domain.PairOfFirstJdnNov
import com.tauari.libsunoom.domain.SetOfLuniSolarMonths
import com.tauari.libsunoom.usecase.conversion.getNextFirstJdnNovOfLeapYear
import com.tauari.libsunoom.usecase.gregorian.getGregorianDateFromJdnLocal
import com.tauari.libsunoom.usecase.sun.getListOfSunLongitudes
import com.tauari.libsunoom.usecase.sun.isMajorTermInside
import kotlin.math.floor

fun getLuniSolarMonths(
    firstJdnPerMonth: List<Double>,
    pairOfFirstJdnNov: PairOfFirstJdnNov,
    timeZoneOffset: Int
): SetOfLuniSolarMonths {
    var months = fillMonths(firstJdnPerMonth, pairOfFirstJdnNov, timeZoneOffset)
    var leapMonthIndex = findLeapMonthIndex(months, firstJdnPerMonth)
    if(leapMonthIndex == -2) {
        //expands this year by 1 month
        leapMonthIndex = 11
        val nextJdnNov = getNextFirstJdnNovOfLeapYear(firstJdnPerMonth[0], timeZoneOffset)
        months = modifyMonthsIfLeap(months, leapMonthIndex)
        months = expandsMonth(months, nextJdnNov, timeZoneOffset)

    }
    if(firstJdnPerMonth.size == 14 && leapMonthIndex >= 0){
        months = modifyMonthsIfLeap(months, leapMonthIndex)
    }
    return SetOfLuniSolarMonths(
        months,
        if(leapMonthIndex == 0) -1 else leapMonthIndex
    )
}

private fun expandsMonth(months: List<LuniSolarMonth>, nextJdnNov: Double, timeZoneOffset: Int): List<LuniSolarMonth> {
    val result: ArrayList<LuniSolarMonth> = arrayListOf()
    result.addAll(months.subList(0,months.size-1))
    result.add(LuniSolarMonth(
        13,
        getGregorianDateFromJdnLocal(nextJdnNov, timeZoneOffset),
        11,
        false,
        nextJdnNov
    ))
    return result
}

fun modifyMonthsIfLeap(months: List<LuniSolarMonth>, leapMonthIndex: Int): List<LuniSolarMonth> {
    if(leapMonthIndex == 0) {
        return shrinkLeapMonthToNormal(months)
    }
    val result = arrayListOf<LuniSolarMonth>()
    val leapMonthValue = getMonthValueFromIndex(leapMonthIndex)
    result.addAll(months)

    var count = 0
    val startIndex = leapMonthIndex + 1
    result[startIndex].isLeap = true
//    result[startIndex].value = leapMonthValue
    for(index in startIndex until(months.size)) {
        val newMonthValue = leapMonthValue + count
        result[index].value = standardMonthValueTo12(leapMonthValue + count)
        count ++
    }
    return result
}

fun shrinkLeapMonthToNormal(months: List<LuniSolarMonth>): List<LuniSolarMonth> {
    val result: ArrayList<LuniSolarMonth> = arrayListOf()
    result.addAll(months.subList(1, months.size))
    result.forEachIndexed { index, month ->
        result[index].index = index
        result[index].value = standardMonthValueTo12(month.value - 1)
    }

    return result
}

private fun standardMonthValueTo12(rawValue: Int): Int {
    return if(rawValue > 12) {
        val k = floor(rawValue / 12f).toInt()
        getRightMonthValue(rawValue - k * 12)
    } else {
        getRightMonthValue(rawValue)
    }
}


private fun fillMonths(firstJdnPerMonth: List<Double>, pairOfFirstJdnNov: PairOfFirstJdnNov, timeZoneOffset: Int): List<LuniSolarMonth> {
    val months = arrayListOf<LuniSolarMonth>()
    months.add(getFirstMonth(pairOfFirstJdnNov.previous, timeZoneOffset))
    val innerMonths = getInnerMonths(firstJdnPerMonth, timeZoneOffset)
    months.addAll(innerMonths)
    months.add(getFirstMonthOfNextYear(firstJdnPerMonth.size, pairOfFirstJdnNov.current, timeZoneOffset))
    return months
}

fun getFirstMonthOfNextYear(
    countMonths: Int,
    jdnNovCurrent: Double,
    timeZoneOffset: Int
): LuniSolarMonth {
    val firstDateInGregorian = getGregorianDateFromJdnLocal(jdnNovCurrent, timeZoneOffset)
    return LuniSolarMonth(
        countMonths - 1,
        firstDateInGregorian,
        11,
        false,
        jdnNovCurrent
    )
}

private fun getFirstMonth(jdnNov: Double, timeZoneOffset: Int): LuniSolarMonth {
    val firstDateInGregorian = getGregorianDateFromJdnLocal(jdnNov, timeZoneOffset)
    return LuniSolarMonth(
        0,
        firstDateInGregorian,
        11,
        false,
        jdnNov
    )
}

fun getInnerMonths(firstJdnPerMonth: List<Double>, timeZoneOffset: Int): List<LuniSolarMonth> {
    val result = arrayListOf<LuniSolarMonth>()
    for (index in 1 until(firstJdnPerMonth.size - 1)) {
        val firstDateInGregorian = getGregorianDateFromJdnLocal(firstJdnPerMonth[index], timeZoneOffset)
        val monthValue = getMonthValueFromIndex(index)
        result.add(
            LuniSolarMonth(
            index,
            firstDateInGregorian,
            monthValue,
            false,
            firstJdnPerMonth[index]
        ))
    }
    return result
}

fun getMonthValueFromIndex(index: Int): Int {
    return getRightMonthValue((index + 11) % 12)
}

fun getRightMonthValue(rawValue: Int): Int {
    return if(rawValue == 0) {
        12
    } else {
        rawValue
    }
}

fun findLeapMonthIndex(months: List<LuniSolarMonth>, firstJdnPerMonth: List<Double>): Int {
    if(months.size == 13 && !isLuniSolarYearLeap(months[2].firstDateInGregorianDate.year)) { return -1 }
    val longitudes = getListOfSunLongitudes(firstJdnPerMonth)
    for(index in 1 until(months.size)) {
        if(isMonthLeap(index, longitudes[index], longitudes[index - 1])) {
            return if(index == 1) 0 else index - 2
        }
    }
    //If for loop passed, but this year still leap, so that the leap month is the first month of next year
    //We need to expand this year by 1 month
    //return flag -2 to warning that
    return -2
}

fun isMonthLeap(monthIndex: Int, currentSunLongitude: Double, prevSunLongitude: Double): Boolean {
    if(monthIndex == 0) { return false }
    val sunLongitudeIndex = (monthIndex + 8) % 12
    val result = ! isMajorTermInside(sunLongitudeIndex, currentSunLongitude, prevSunLongitude)
    return result
}
