package lotto.domain.number

class Numbers private constructor(val winningNumbers: List<Number>) {

    companion object {
        const val WINNING_NUMBER_COUNT = 6

        fun fromInts(vararg numbers: Int): Numbers {
            require(numbers.distinct().size == WINNING_NUMBER_COUNT) {
                "Winning numbers must be $WINNING_NUMBER_COUNT unique values"
            }
            val numberList = numbers.map { Number(it) }
            return Numbers(numberList)
        }
    }

    init {
        require(winningNumbers.size == winningNumbers.distinct().size) {
            "Winning numbers must not contain duplicates"
        }
        require(winningNumbers.size == WINNING_NUMBER_COUNT) {
            "Winning numbers size must equal to $WINNING_NUMBER_COUNT"
        }
    }

    fun match(otherNumbers: Numbers): Int {
        return winningNumbers.count { it in otherNumbers.winningNumbers }
    }

    fun match(bonusNumber: BonusNumber): Boolean {
        return winningNumbers.any { bonusNumber.number == it.number }
    }
}