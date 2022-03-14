package com.tauari.libsunoom.usecase

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.usecase.conversion.getLuniSolarDateFromGregorian
import java.util.*
import kotlin.collections.ArrayList

fun getDaysBetweenDates(
    startdate: Date,
    enddate: Date,
    timeZone: TimeZone,
    includeEndDate: Boolean = false)
: ArrayList<Pair<GregorianDate, LuniSolarDate>> {
    val dates = ArrayList<Pair<GregorianDate, LuniSolarDate>>()
//    val timeZone = SnTimeZone.getTimeZone(timeZone)
    val calendar = GregorianCalendar.getInstance(timeZone)
    calendar.time = startdate
    val modifyEnddate = GregorianCalendar.getInstance(timeZone)
    modifyEnddate.time = enddate
    if(includeEndDate) {
        modifyEnddate.add(GregorianCalendar.DAY_OF_MONTH, 1)
    }

    while (calendar.time.before(modifyEnddate.time)) {
        val dayOfMonth = calendar.get(GregorianCalendar.DAY_OF_MONTH)
        val month = calendar.get(GregorianCalendar.MONTH) + 1
        val year = calendar.get(GregorianCalendar.YEAR)
        val gregorianDate = GregorianDate(dayOfMonth, month, year, getTimeZoneOffsetInHour(timeZone))
        val lunarDate = getLuniSolarDateFromGregorian(gregorianDate)
        lunarDate?.let {
            dates.add(Pair(gregorianDate, it))
        }
        calendar.add(Calendar.DATE, 1)
    }
    return dates
}