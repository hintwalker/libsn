package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Can
import com.tauari.libsunoom.enums.Chi

fun getHoaGiapIndexOfCanChi(canOfYear: Can, chiOfYear: Chi): Int {
    val row = getRow(canOfYear)
    return indexOfItemInRow(chiOfYear, row)
}

private fun getRow(canOfYear: Can): List<Int> {
    val data = listOf(
        listOf(0, 10, 8, 6, 4, 2),
        listOf(1, 11, 9, 7, 5, 3),
        listOf(2, 0, 10, 8, 6, 4),
        listOf(3, 1, 11, 9, 7, 5),
        listOf(4, 2, 0, 10, 8, 6),
        listOf(5, 3, 1, 11, 9, 7),
        listOf(6, 4, 2, 0, 10, 8),
        listOf(7, 5, 3, 1, 11, 9),
        listOf(8, 6, 4, 2, 0, 10),
        listOf(9, 7, 5, 3, 1, 11)
    )
    return data[canOfYear.ordinal]
}

private fun indexOfItemInRow(chiOfYear: Chi, row: List<Int>): Int {
    for(index in 0 until(row.size)) {
        if(row[index] == chiOfYear.ordinal) {
            return index
        }
    }
    return -1
}