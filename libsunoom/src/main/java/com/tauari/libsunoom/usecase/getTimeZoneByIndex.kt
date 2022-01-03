package com.tauari.libsunoom.usecase

import java.util.*

fun getTimeZoneByIndex(index: Int): TimeZone {
    return TimeZone.getTimeZone(TimeZone.getAvailableIDs()[index])
}