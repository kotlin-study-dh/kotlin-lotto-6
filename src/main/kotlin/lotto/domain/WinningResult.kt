package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class WinningResult(
    private val resultsByRank: Map<LottoRank, Int>
) {
    constructor(
        lottos: List<Lotto>,
        winningNumbers: WinningNumbers
    ) : this(
        calculateResult(lottos, winningNumbers)
    )

    companion object {
        fun calculateResult(lottos: List<Lotto>, winningNumbers: WinningNumbers): Map<LottoRank, Int> {
            val winningResult = mutableMapOf<LottoRank, Int>().withDefault { 0 }
            LottoRank.entries.forEach { rank ->
                winningResult[rank] = 0
            }

            for (lotto in lottos) {
                val matchingResultCnt = winningNumbers.calculateMatchingNumber(lotto)
                val rank = when (matchingResultCnt) {
                    LottoRank.SIX_MATCH.matchCounts -> LottoRank.SIX_MATCH
                    LottoRank.FIVE_BONUS_MATCH.matchCounts ->
                        if (winningNumbers.hasBonusNumber(lotto)) LottoRank.FIVE_BONUS_MATCH
                        else LottoRank.FIVE_MATCH
                    LottoRank.FOUR_MATCH.matchCounts -> LottoRank.FOUR_MATCH
                    LottoRank.THREE_MATCH.matchCounts -> LottoRank.THREE_MATCH
                    else -> LottoRank.NONE_MATCH
                }
                winningResult[rank] = winningResult.getValue(rank) + 1
            }
            return winningResult
        }
        private const val PERCENT_RATE = 100
    }

    fun calculateProfitRate(purchaseAmount: Int): BigDecimal {
        val profit = calculateProfit().toBigDecimal()
        val purchaseAmount = (Lotto.LOTTO_PRICE * purchaseAmount).toBigDecimal()

        return (BigDecimal(PERCENT_RATE).multiply(profit)
            .divide(purchaseAmount, 1, RoundingMode.HALF_UP))
    }

    private fun calculateProfit(): Int = resultsByRank.entries.sumOf { (rank, count) ->
        rank.prizeAmount * count
    }

    fun getByRank(lottoRank: LottoRank) = resultsByRank[lottoRank]
}
