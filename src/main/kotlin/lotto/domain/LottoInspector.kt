package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.WinningNumbers

class LottoInspector(val winningNumbers: WinningNumbers) {

    fun inspect(otherWinningNumbers: WinningNumbers, bonusNumber: BonusNumber): Score {
        val winningMatch = winningNumbers.match(otherWinningNumbers)
        val bonusMatch = winningNumbers.match(bonusNumber)
        return Score.from(winningMatch, bonusMatch)
    }
}