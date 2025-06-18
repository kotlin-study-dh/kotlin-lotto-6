package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.WinningNumbers

class LottoInspector(val winningNumbers: WinningNumbers, val bonusNumber: BonusNumber) {

    fun inspect(guessingNumbers: WinningNumbers): Score {
        val winningMatch = guessingNumbers.match(winningNumbers)
        val bonusMatch = guessingNumbers.match(bonusNumber)
        return Score.from(winningMatch, bonusMatch)
    }
}