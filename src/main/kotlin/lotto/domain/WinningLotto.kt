package lotto.domain

class WinningLotto(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(bonusNumber !in winningNumbers) {
            "Bonus number must not be included in the winning numbers."
        }
    }

    fun countMatchingNumbers(lotto: Lotto): Int {
        return winningNumbers.getMatchCount(lotto)
    }

    fun isBonusNumberMatchedBy(lotto: Lotto): Boolean {
        return bonusNumber in lotto
    }
}
