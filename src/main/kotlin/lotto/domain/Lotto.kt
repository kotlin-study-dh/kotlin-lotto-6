package lotto.domain

import lotto.common.RandomNumbersGenerator
import lotto.constant.LottoConstants

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LottoConstants.NUMBERS_AMOUNT) {
            "Lotto must contain ${LottoConstants.NUMBERS_AMOUNT} numbers."
        }
        require(numbers.size == numbers.distinct().size) { "There must not be duplication in lotto numbers." }
    }

    constructor() : this(
        RandomNumbersGenerator.generate(
            LottoConstants.MIN_NUMBER,
            LottoConstants.MAX_NUMBER,
            LottoConstants.NUMBERS_AMOUNT
        )
    )

    fun calculateRank(winningNumbers: WinningNumbers, bonusNumber: Int) = LottoRank.of(
        matchCount = numbers.count { it -> winningNumbers.contains(it) },
        matchesBonus = numbers.contains(bonusNumber)
    )

    fun getNumbers() = numbers
}
