package lotto.domain

import lotto.constant.LottoConstants

class LottoGame(
    private val lottos: Lottos,
    private val winningNumbers: WinningNumbers,
    private val bonusNumber: Int
) {

    init {
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
