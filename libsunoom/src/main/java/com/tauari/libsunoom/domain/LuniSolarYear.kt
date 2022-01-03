package com.tauari.libsunoom.domain

data class LuniSolarYear(
    var months: List<LuniSolarMonth>,
    var leapMonthIndex: Int,
    var timeZoneOffset: Int
) {
    fun getMonthOfDate(date: LuniSolarDate): LuniSolarMonth? {
        val resultList = this.months.filter {
                month -> (month.value == date.month) && (month.isLeap == date.isLeapMonth) }
        return if(resultList.isNotEmpty()) {
            resultList[0]
        } else {
            null
        }

    }

    fun countMonths(): Int {
        return this.months.size
    }

    fun getLeapMonth(): LuniSolarMonth? {
        return if(this.isLeap()) {
            this.months[this.leapMonthIndex]
        } else {
            null
        }
    }

    fun isLeap(): Boolean {
        return this.countMonths() == 14
    }

    fun getYearValue(): Int {
        return this.months[2].firstDateInGregorianDate.year
    }
}
