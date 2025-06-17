package lotto.domain

class WinningNumbers private constructor(winningNumbers: List<Number> = listOf()) {

    init {
        if (winningNumbers.size != winningNumbers.distinct().size) {
            throw IllegalArgumentException("Winning numbers can not be duplicated")
        }
        if (winningNumbers.size != WINNING_NUMBER_COUNT) {
            throw IllegalArgumentException("Winning numbers size must equal to $WINNING_NUMBER_COUNT")
        }
    }

    companion object {
        const val WINNING_NUMBER_COUNT = 6

        fun fromInts(vararg numbers: Int): WinningNumbers {
            val numberList = numbers.map { Number(it) }
            return WinningNumbers(numberList)
        }
    }
}