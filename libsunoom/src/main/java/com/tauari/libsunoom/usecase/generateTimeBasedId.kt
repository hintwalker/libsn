package com.tauari.libsunoom.usecase

import java.util.*

fun generateTimeBasedId(): Long {
    return Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh")).timeInMillis
}