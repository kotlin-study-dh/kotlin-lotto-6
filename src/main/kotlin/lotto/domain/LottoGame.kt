package lotto.domain

import lotto.constant.LottoConstants

class LottoGame(
    private val lottos: Lottos,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    init {
        require(winningNumbers.size == LottoConstants.NUMBERS_AMOUNT) {
            "There must be ${LottoConstants.NUMBERS_AMOUNT} winning numbers."
        }

        require(bonusNumber in LottoConstants.MIN_NUMBER..LottoConstants.MAX_NUMBER) {
            "Bonus number must be between ${LottoConstants.MIN_NUMBER} and ${LottoConstants.MAX_NUMBER}."
        }
    }

    fun result(): Map<LottoRank, Int> {
        return lottos.getElements().map { it.calculateRank(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }
}
