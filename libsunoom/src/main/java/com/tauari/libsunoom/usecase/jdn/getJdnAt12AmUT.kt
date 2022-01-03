package com.tauari.libsunoom.usecase.jdn

fun getJdnAt12AmUT(dayOfMonth: Int, month: Int, year: Int): Int {
    return 1461 * (year + 4800 + (month - 14) / 12) / 4 +
            (367 * (month - 2 - 12 * ((month - 14) / 12))) / 12 -
            (3 * ((year + 4900 + (month - 14) / 12) / 100)) / 4 +
            dayOfMonth - 32075
}