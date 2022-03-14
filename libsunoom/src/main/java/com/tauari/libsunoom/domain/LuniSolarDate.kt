package com.tauari.libsunoom.domain

data class LuniSolarDate(
    var dayOfMonth: Int,
    var month: Int,
    var year: Int,
    var isLeapMonth: Boolean,
    var timeZoneOffset: Int) {
    override fun toString(): String {
        val leapMonthDescribe = if(isLeapMonth) " (tháng nhuận)" else ""
        return "$dayOfMonth-$month-$year$leapMonthDescribe"
    }

    fun areTheSame(other: LuniSolarDate): Boolean {
        return dayOfMonth == other.dayOfMonth
                || month == other.month
                || year == other.year
                || isLeapMonth == other.isLeapMonth
                ||timeZoneOffset == other.timeZoneOffset
    }
}
