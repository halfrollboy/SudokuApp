package org.sudoku
typealias GameBoard = Map<Coordinate, Int>

fun validateGame(input: GameBoard, solution: GameBoard): CheckOutCome {
    var result = CheckOutCome.OK
    for (i in 0 until 9) {
        val rowCheckOutcome =
            validateSimilar(input, solution, rowGenerateNumber(rowNumber = i))
        if (rowCheckOutcome != CheckOutCome.OK) {
            result = rowCheckOutcome
            break
        }
        val columnCheckOutcome = validateSimilar(input, solution, colGenerateNumber(colNumber = i))
        if (columnCheckOutcome != CheckOutCome.OK) {
            result = columnCheckOutcome
            break
        }
        val quadrantCheckOutcome = validateSimilar(input, solution, quadGenerateNumber(quadNumber = i))
        if (quadrantCheckOutcome != CheckOutCome.OK) {
            result = quadrantCheckOutcome
            break
        }
    }
    return result
}

fun validateSimilar(
    input: GameBoard,
    solution: GameBoard,
    coordinateGenerator: Generator
): CheckOutCome {
    for (i in 0 until 8) {
        val checkedCoordinate = coordinateGenerator(i)
        val checkedValue = input[checkedCoordinate] ?: solution[checkedCoordinate] ?: return CheckOutCome.INCOMPLITE
        for (j in i + 1 until 9) {
            val internalCoordinate = coordinateGenerator(j)
            val internalValue =
                input[internalCoordinate] ?: solution[internalCoordinate] ?: return CheckOutCome.INCOMPLITE
            if (checkedValue == internalValue) {
                return CheckOutCome.FAILED
            }
        }
    }
    return CheckOutCome.OK
}