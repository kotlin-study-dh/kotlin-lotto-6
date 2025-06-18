package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.RandomNumberGenerator
import lotto.domain.number.WinningNumbers

class LottoPlayer(private val winningNumbers: WinningNumbers, private val bonusNumbers: BonusNumber) {

    fun play(count: Int): List<Score> {
        val issuer = LottoIssuer(RandomNumberGenerator())
        val inspector = LottoInspector(winningNumbers, bonusNumbers)
        return List(count) {
            val guessingNumbers = issuer.issue()
            inspector.inspect(guessingNumbers)
        }
    }
}