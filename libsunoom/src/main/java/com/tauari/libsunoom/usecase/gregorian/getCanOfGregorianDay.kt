package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.SunoomTime
import com.tauari.libsunoom.enums.Can
import com.tauari.libsunoom.usecase.jdn.getJdnAt12AmUT

fun getCanOfGregorianDay(date: GregorianDate, time: SunoomTime? = null): Can {
    var jdn = getJdnAt12AmUT(date.dayOfMonth, date.month, date.year)
    if(time?.hour == 23) {
        jdn += 1
    }
    return Can.fromInt( (jdn + 9) % 10)
}