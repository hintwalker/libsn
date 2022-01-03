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
}
