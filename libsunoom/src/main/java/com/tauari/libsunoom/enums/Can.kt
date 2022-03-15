package com.tauari.libsunoom.enums

import kotlin.jvm.Throws

enum class Can {
    GIAP,
    AT,
    BINH,
    DINH,
    MAU,
    KY,
    CANH,
    TAN,
    NHAM,
    QUY;
    companion object {
        @Throws(NoSuchElementException::class)
        fun fromInt(value: Int): Can {
            return Can.values().first(){v -> v.ordinal == value}
        }
    }
}
