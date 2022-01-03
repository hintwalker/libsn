package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.enums.Can
import com.tauari.libsunoom.usecase.jdn.getJdnAt12AmUT

fun getCanOfGregorianDay(date: GregorianDate): Can {
    val jdn = getJdnAt12AmUT(date.dayOfMonth, date.month, date.year)
    return Can.fromInt( (jdn + 9) % 10)
}