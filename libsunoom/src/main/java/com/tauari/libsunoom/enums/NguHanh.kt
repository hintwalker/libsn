package com.tauari.libsunoom.enums

import kotlin.jvm.Throws

enum class NguHanh(val value: Int) {
    THUY(2),
    MOC(3),
    KIM(4),
    THO(5),
    HOA(6);
    companion object {
        @Throws(NoSuchElementException::class)
        fun fromInt(value: Int): NguHanh {
            return values().first { v -> v.value == value }
        }
    }
}