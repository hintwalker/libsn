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
import com.tauari.libsunoom.usecase.gregorian.isToday
import java.util.*

fun getDateType(date: SunoomDate, options: DateTypeOption): Int {
    return if(isOutOfTable(date.gregorianDate, options.targetMonth)) {
        if(isFirstDateOfMonth(date)) {
            FIRST_DATE_OF_MONTH or OUT_OF_TABLE
        } else {
            OUT_OF_TABLE
        }
    }
    else if(isToday(date.gregorianDate, TimeZone.getDefault())) {
        if(isFirstDateOfMonth(date)) {
            TODAY or FIRST_DATE_OF_MONTH
        } else {
            TODAY or NORMAL_DATE
        }
    } else {
        if(isFirstDateOfMonth(date)) {
            FIRST_DATE_OF_MONTH
        } else {
            NORMAL_DATE
        }
    }
}