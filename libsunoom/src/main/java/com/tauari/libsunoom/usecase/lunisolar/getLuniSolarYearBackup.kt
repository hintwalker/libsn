package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.domain.LuniSolarYear
import com.tauari.libsunoom.domain.PairOfFirstJdnNov
import com.tauari.libsunoom.usecase.conversion.getListOfFirstJdnPerMonth
import com.tauari.libsunoom.usecase.conversion.getPairOfFirstJdn
import com.tauari.libsunoom.usecase.conversion.getPairOfFirstJdnApprox
import com.tauari.libsunoom.usecase.gregorian.getGregorianDateFromJdnLocal

fun getLuniSolarYear2(date: LuniSolarDate): LuniSolarYear {
    val gregorianYear = findGregorianYear(date)
    val pairOfFirstJdnNov = getPairOfFirstJdnApprox(gregorianYear, date.timeZoneOffset)
    return fromPairOfFirstJdnNov(pairOfFirstJdnNov, date.timeZoneOffset)
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

fun getLuniSolarYear2(date: GregorianDate): LuniSolarYear {
    val pairOfFirstJdnNov = getPairOfFirstJdn(date.year, date.timeZoneOffset)
    return fromPairOfFirstJdnNov(pairOfFirstJdnNov, date.timeZoneOffset)
}