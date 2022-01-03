package com.tauari.libsunoom.usecase

import java.util.*

fun getCurrentTimeZone(): TimeZone {
    return GregorianCalendar().timeZone
}