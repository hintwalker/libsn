package com.tauari.libsunoom.usecase

import java.util.*

fun getTimeZoneOffsetInHour(timeZone: TimeZone): Int {
    val rawOffset =timeZone.rawOffset
    return rawOffset / 3600000
}