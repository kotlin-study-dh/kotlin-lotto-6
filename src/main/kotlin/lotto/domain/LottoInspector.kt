package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.Numbers

class LottoInspector(val winningNumbers: Numbers, val bonusNumber: BonusNumber) {

    fun inspect(guessingNumbers: List<Numbers>): List<Score> {
        return guessingNumbers.map { guessingNumber ->
            val winningMatch = guessingNumber.match(winningNumbers)
            val bonusMatch = guessingNumber.match(bonusNumber)
            Score.from(winningMatch, bonusMatch)
        }
    }
}