package lotto.domain

class LottoGame(
    private val lottos: Lottos,
    private val winningNumbers: WinningNumbers,
    private val bonusNumber: LottoNumber
) {

    fun result(): Map<LottoRank, Int> {
        return lottos.getElements().map { it.calculateRank(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }
}
