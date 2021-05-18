package org.sudoku


typealias Generator = (Int) -> Coordinate

fun rowGenerateNumber(rowNumber: Int): Generator = {index -> Coordinate(rowNumber, index)}
fun colGenerateNumber(colNumber: Int): Generator = {index -> Coordinate(index, colNumber)}
fun quadGenerateNumber(quadNumber: Int): Generator = {index ->
    val x= 3*(quadNumber/3) + index/3
    val y= 3*(quadNumber%3) + index%3
    Coordinate(x,y)
}