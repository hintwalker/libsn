package com.tauari.libsunoom.usecase.jdn

import com.tauari.libsunoom.constants.TimeConstant.FIRST_YEAR_OF_GREGORIAN_CALENDAR
import com.tauari.libsunoom.constants.TimeConstant.JDN_AT_0_ON_13NOV23_UT
import com.tauari.libsunoom.constants.TimeConstant.JDN_AT_0_ON_1DEC1BC_UT

fun getJdnAt00UT(day: Int, month: Int, year: Int): Double {
    val JD: Double = if (
        year > FIRST_YEAR_OF_GREGORIAN_CALENDAR
        || (year == FIRST_YEAR_OF_GREGORIAN_CALENDAR && month > 10)
        || (year == FIRST_YEAR_OF_GREGORIAN_CALENDAR && month == 10 && day > 14)) {
        367 * year - (7 * (year + ((month + 9) / 12).toInt()) / 4).toInt() - (
                3 * (((year + (month - 9) / 7) / 100).toInt() + 1) / 4
                ).toInt() + (275 * month / 9).toInt() + day + JDN_AT_0_ON_1DEC1BC_UT
    } else {
        367 * year - (7 * (year + 5001 + ((month - 9) / 7)).toInt() / 4).toInt() + (
                275 * month / 9
                ).toInt() + day + JDN_AT_0_ON_13NOV23_UT
    }
    return JD
}