package com.tauari.libsunoom.constants

enum class DateType(val intValue:Int) {
    TODAY("TODAY".hashCode()),
    FIRST_DATE_OF_MONTH("FIRST_DATE_OF_MONTH".hashCode()),
    NORMAL_DATE("NORMAL_DATE".hashCode()),
    OUT_OF_TABLE("OUT_OF_TABLE".hashCode()),
    WEEKEND("WEEKEND".hashCode()),
    FESTIVAL("FESTIVAL".hashCode()),
    HAS_EVENTS("HAS_EVENT".hashCode()),
    TET("TET".hashCode())
}

//object DateType2 {
//    const val NORMAL_DATE = "NORMAL_DATE".hashCode()
//    const val FIRST_DATE_OF_TABLE = 0x000002
//    const val END_DATE_OF_TABLE = 0x000003
//    const val OUT_OF_TABLE = 0x000004
//    const val FESTIVAL = 0x000005
//    const val HAS_EVENTS = 0x000006
//    const val TET = 0x000007
//
//    const val TODAY = 0x000008
////    const val TODAY_IS_NORMAL_DATE = 10
////    const val TODAY_IS_FIRST_DATE_OF_MONTH = 11
////    const val TODAY_IS_TET = 12
////    const val TODAY_HAS_FESTIVAL = 13
////    const val TODAY_HAS_EVENTS = 14
////    const val TODAY_IS_WEEKEND = 15
//
//    const val FIRST_DATE_OF_MONTH = 0xF00009
////    const val FIRST_DATE_OF_MONTH_BUT_OUT_OF_TABLE = 10
//
////    const val NORMAL_DATE_IS_TET = 16
//    const val WEEKEND = 0x000010
//
//
//
//}