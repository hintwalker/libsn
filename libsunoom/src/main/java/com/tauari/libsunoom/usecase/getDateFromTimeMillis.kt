package com.tauari.libsunoom.usecase

import java.util.*

fun getDateFromTimeMillis(time: Long): Calendar {
    val date = GregorianCalendar.getInstance()
    date.timeInMillis = time
    return date
}