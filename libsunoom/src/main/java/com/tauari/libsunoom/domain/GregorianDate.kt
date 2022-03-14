package com.tauari.libsunoom.domain

data class GregorianDate(var dayOfMonth: Int, var month: Int, var year: Int, var timeZoneOffset: Int) {
    override fun toString(): String {
        return "$dayOfMonth-$month-$year"
    }

    fun areTheSame(other: GregorianDate): Boolean {
        return dayOfMonth == other.dayOfMonth
                && month == other.month
                && year == other.year
                && timeZoneOffset == other.timeZoneOffset
    }
}
