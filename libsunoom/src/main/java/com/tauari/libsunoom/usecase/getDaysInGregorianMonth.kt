package com.tauari.libsunoom.usecase

import com.tauari.libsunoom.domain.SunoomDate
import java.util.*

/***
 * @param month month value: 1 to 12
 */
fun getDaysInGregorianMonth(
    year: Int,
    month: Int,
    timeZone: TimeZone,
    isFullGrid: Boolean = true
): List<SunoomDate> {
    val startCalendar = GregorianCalendar.getInstance(timeZone)
    var endCalendar = GregorianCalendar.getInstance(timeZone)

    startCalendar.set(year, month -1, 1)
    endCalendar.set(year, month - 1,1)
    val maxDayInMonth = endCalendar.getActualMaximum(GregorianCalendar.DATE)
    endCalendar.set(GregorianCalendar.DATE, maxDayInMonth)

    if(isFullGrid) {
        val missingFirstDays = numMissingFirstDays(startCalendar)
        startCalendar.add(GregorianCalendar.DATE, missingFirstDays * -1)
        endCalendar = startCalendar.clone() as GregorianCalendar
        endCalendar.add(GregorianCalendar.DATE, 41)
    }
    val pairOfDates = getDaysBetweenDates(startCalendar.time, endCalendar.time, timeZone, true)
    val dates = pairOfDates.map {
        SunoomDate(it.first, it.second)

    }
    return dates
}

private fun numMissingFirstDays(startDate: Calendar): Int {
    val firstDayOfWeek = startDate.get(GregorianCalendar.DAY_OF_WEEK)
    return if(firstDayOfWeek == 1) 6 else firstDayOfWeek - 2
}


private fun numMissingEndDays(endDate: Calendar): Int {
    val endDayOfWeek = endDate.get(GregorianCalendar.DAY_OF_WEEK)
    return if(endDayOfWeek == 1) 0 else 8 - endDayOfWeek
}