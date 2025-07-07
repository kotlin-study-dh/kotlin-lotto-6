package lotto.domain

class LottoGame(
    private val lottos: Lottos,
    private val winningNumbers: WinningNumbers,
    private val bonusNumber: LottoNumber
) {

    init {
        require(!winningNumbers.contains(bonusNumber)) {
            "There must be no duplication between winning numbers and bonus number"
        }
    }

    fun result(): LottoGameResult {
        return lottos.elements
            .map { lotto -> lotto.calculateRank(winningNumbers, bonusNumber) }
            .let { ranks -> LottoGameResult(ranks) }
    }
}
