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

    fun result(): Map<LottoRank, Int> {
        return lottos.getElements().map { it.calculateRank(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }
}
