package lotto.generator

interface NumbersGenerator {
    fun generate(): List<Int>

    companion object {
        const val NUMBER_COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
