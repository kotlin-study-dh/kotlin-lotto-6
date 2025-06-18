package lotto.domain

import lotto.common.RandomNumbersGenerator

private const val START_NUMBER = 1
private const val END_NUMBER = 45
private const val NUMBERS_AMOUNT = 6

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == NUMBERS_AMOUNT) { "Lotto must contain $NUMBERS_AMOUNT numbers." }
        require(numbers.size == numbers.distinct().size) { "There must not be duplication in lotto numbers." }
    }

    constructor() : this(
        RandomNumbersGenerator.generate(START_NUMBER, END_NUMBER, NUMBERS_AMOUNT)
    )

    fun calculateRank(winningNumbers: List<Int>, bonusNumber: Int) = LottoRank.of(
        matchCount = numbers.count { it -> winningNumbers.contains(it) },
        matchesBonus = numbers.contains(bonusNumber)
    )

    fun getNumbers() = numbers
}
