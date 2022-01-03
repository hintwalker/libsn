package com.tauari.libsunoom.usecase

import com.tauari.libsunoom.usecase.conversion.getLuniSolarDateFromGregorian
import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.SunoomDate
import java.util.*

fun getTodayInSunoom(timeZone: TimeZone): SunoomDate? {
    val dateNow = GregorianCalendar.getInstance(timeZone)
    val gregorianDate = GregorianDate(
        dateNow.get(Calendar.DAY_OF_MONTH),
        dateNow.get(Calendar.MONTH) + 1,
        dateNow.get(Calendar.YEAR),
        getTimeZoneOffsetInHour(timeZone)
    )
    val luniSolarDate = getLuniSolarDateFromGregorian(gregorianDate)

    return if(luniSolarDate == null) {
        null
    } else {
        SunoomDate(
            gregorianDate,
            luniSolarDate
        )
    }
}