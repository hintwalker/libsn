package com.tauari.libsunoom.enums

import kotlin.jvm.Throws

enum class DayOfWeek(val value: Int) {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);
    companion object {
        @Throws(NoSuchElementException::class)
        fun fromInt(value: Int): DayOfWeek {
            return DayOfWeek.values().first { v -> v.value == value }
        }
    }
}