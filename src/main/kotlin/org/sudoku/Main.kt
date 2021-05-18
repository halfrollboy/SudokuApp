@file:JvmName("Main")
package org.sudoku

import java.io.File


fun main(){
    val input = reedFile("input")
    val solution = reedFile("solution")
    //Проверка валидности наших введённых данных
    println(validateGame(input, solution))
}

fun reedFile(fileName: String): GameBoard = File(fileName)
        .readLines() //Читает файл построчно
        .withIndex()
        .flatMap { indexedValue ->
            val xCoordinate = indexedValue.index
            indexedValue.value.toCharArray().withIndex()
                .filter { indexedChar -> indexedChar.value != '.'}
                .map{
                        indexedChar ->
                    val yCoordinate = indexedChar.index
                    val coordiante = Coordinate(xCoordinate, yCoordinate)
                    val number = Character.getNumericValue(indexedChar.value)
                    coordiante to number
                }
        }//После этих преобразований получаем хэш мэп где в ключах пара х,у
        .toMap()


enum class CheckOutCome{
    OK,
    INCOMPLITE,
    FAILED
}
