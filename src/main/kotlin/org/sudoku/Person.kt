package org.sudoku

class Person(val name: String, val work: String, val ill:Boolean = false) {
    override fun toString(): String {
        return "$name - $work"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (work != other.work) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + work.hashCode()
        return result
    }
}