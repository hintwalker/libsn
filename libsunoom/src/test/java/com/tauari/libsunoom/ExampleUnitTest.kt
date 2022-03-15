package com.tauari.libsunoom

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }



    @Test
    fun dateType_isTheSame() {
//        assertEquals("TODAY".hashCode(), "TODAY".hashCode() or "FIRST_DATE_OF_MONTH".hashCode())
        assertEquals("OUT_OF_TABLE".hashCode() or "FIRST_DATE_OF_MONTH".hashCode(), "TODAY".hashCode() or "OUT_OF_TABLE".hashCode() or "FIRST_DATE_OF_MONTH".hashCode())
//        assertEquals(DateType2.TODAY, [DateType2.TODAY | DateType2.FIRST_DATE_OF_MONTH])
    }
}