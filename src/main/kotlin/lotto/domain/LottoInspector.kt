package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.Numbers

class LottoInspector(val numbers: Numbers, val bonusNumber: BonusNumber) {

    fun inspect(guessingNumbers: Numbers): Score {
        val winningMatch = guessingNumbers.match(numbers)
        val bonusMatch = guessingNumbers.match(bonusNumber)
        return Score.from(winningMatch, bonusMatch)
    }
}