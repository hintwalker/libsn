package com.tauari.libsunoom.enums

import kotlin.jvm.Throws

enum class Chi {
    TYS,
    SUU,
    DAN,
    MAO,
    THIN,
    TYJ,
    NGO,
    MUI,
    THAN,
    DAU,
    TUAT,
    HOI;
    companion object {
        @Throws(NoSuchElementException::class)
        fun fromInt(value: Int): Chi {
            return Chi.values().first(){v -> v.ordinal == value}
        }
    }
}