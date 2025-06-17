package lotto.domain

import java.util.EnumMap


class WinningLotto(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber,
) {

    init {
        require(bonusNumber !in winningNumbers) {
            "Bonus number must not be included in the winning numbers."
        }
    }

    fun compareTo(lottos: List<Lotto>): Map<Prize, Int> {
        val prizeCounts = initializePrizeCounts()
        for (lotto in lottos) {
            val matchCount = winningNumbers.getMatchCount(lotto)
            val hasBonusNumber = bonusNumber in lotto
            val prize = Prize.of(matchCount, hasBonusNumber)
            prizeCounts.merge(prize, 1, Int::plus)
        }
        return prizeCounts
    }

    private fun initializePrizeCounts(): EnumMap<Prize, Int> =
        EnumMap<Prize, Int>(Prize::class.java).apply { Prize.entries.forEach { put(it, 0) } }
}
