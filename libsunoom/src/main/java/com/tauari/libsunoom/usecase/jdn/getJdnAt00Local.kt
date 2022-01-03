package com.tauari.libsunoom.usecase.jdn

import com.tauari.libsunoom.constants.TimeConstant.HOURS_PER_DAY
import com.tauari.libsunoom.domain.GregorianDate

fun getJdnAt00Local(date: GregorianDate): Double {
    return getJdnAt00UT(date.dayOfMonth, date.month, date.year) - date.timeZoneOffset / HOURS_PER_DAY
}