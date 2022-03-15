package com.tauari.libsunoom.usecase

import com.tauari.libsunoom.constants.DateType
import com.tauari.libsunoom.constants.DateType.FIRST_DATE_OF_MONTH
//import com.tauari.libsunoom.constants.DateType.FIRST_DATE_OF_MONTH_BUT_OUT_OF_TABLE
import com.tauari.libsunoom.constants.DateType.NORMAL_DATE
import com.tauari.libsunoom.constants.DateType.OUT_OF_TABLE
import com.tauari.libsunoom.constants.DateType.TODAY
//import com.tauari.libsunoom.constants.DateType.TODAY_IS_FIRST_DATE_OF_MONTH
//import com.tauari.libsunoom.constants.DateType.TODAY_IS_NORMAL_DATE
import com.tauari.libsunoom.domain.DateTypeOption
import com.tauari.libsunoom.domain.SunoomDate
import com.tauari.libsunoom.enums.DayOfWeek
import com.tauari.libsunoom.usecase.gregorian.getDayOfWeek
import com.tauari.libsunoom.usecase.gregorian.isToday
import java.util.*

fun getDateType(date: SunoomDate, options: DateTypeOption): Int {
    var result = NORMAL_DATE.intValue
    val dayOfWeek = getDayOfWeek(date.gregorianDate)

    val value1 = if(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
        DateType.WEEKEND.intValue
    } else {
        null
    }

    val value2 = if(isOutOfTable(date.gregorianDate, options.targetMonth)) {
        if(isFirstDateOfMonth(date)) {
            FIRST_DATE_OF_MONTH.intValue or OUT_OF_TABLE.intValue
        } else {
            OUT_OF_TABLE.intValue
        }
    }
    else if(isToday(date.gregorianDate, TimeZone.getDefault())) {
        if(isFirstDateOfMonth(date)) {
            TODAY.intValue or FIRST_DATE_OF_MONTH.intValue
        } else {
            TODAY.intValue or NORMAL_DATE.intValue
        }
    } else {
        if(isFirstDateOfMonth(date)) {
            FIRST_DATE_OF_MONTH.intValue
        } else {
            NORMAL_DATE.intValue
        }
    }

    result = if(value1 != null) {
        value1 or value2
    } else {
        value2
    }

    return result
}