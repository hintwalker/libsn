package com.tauari.libsunoom.usecase.jdn

import com.tauari.libsunoom.constants.TimeConstant.DAYS_PER_LUNAR_MONTH
import com.tauari.libsunoom.constants.TimeConstant.JDN_AT_13_50_5269_ON_1Jan1990_UT

fun countMonthsFrom1Jan1900UT(jdn: Double): Int {
    return ((jdn - JDN_AT_13_50_5269_ON_1Jan1990_UT) / DAYS_PER_LUNAR_MONTH).toInt()
}