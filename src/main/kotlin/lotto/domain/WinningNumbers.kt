package lotto.domain

class WinningNumbers private constructor(winningNumbers: List<Number>) {

    companion object {
        const val WINNING_NUMBER_COUNT = 6

        fun fromInts(vararg numbers: Int): WinningNumbers {
            if (numbers.distinct().size != WINNING_NUMBER_COUNT) {
                "Winning numbers must be $WINNING_NUMBER_COUNT unique values"
            }

            val numberList = numbers.map { Number(it) }
            return WinningNumbers(numberList)
        }
    }

    init {
        require(winningNumbers.size == winningNumbers.distinct().size) {
            throw IllegalArgumentException("Winning numbers must not contain duplicates")
        }
        require(winningNumbers.size == WINNING_NUMBER_COUNT) {
            throw IllegalArgumentException("Winning numbers size must equal to $WINNING_NUMBER_COUNT")
        }
    }
}