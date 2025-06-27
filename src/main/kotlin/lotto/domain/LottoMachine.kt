package lotto.domain

import lotto.generator.NumbersGenerator
import java.util.EnumMap

class LottoMachine {
    fun issueLottos(purchaseAmount: LottoPurchaseAmount, numbersGenerator: NumbersGenerator): List<Lotto> {
        val purchaseQuantity = purchaseAmount.purchaseQuantity
        return List(purchaseQuantity) {
            val lottoNumbers = numbersGenerator.generate()
                .map { LottoNumber.from(it) }
                .sortedBy { it.number }
            Lotto(lottoNumbers)
        }
    }

    fun issueWinningLotto(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto(
            Lotto(winningNumbers.map { LottoNumber.from(it) }),
            LottoNumber.from(bonusNumber)
        )
    }

    fun getWinningResult(winningLotto: WinningLotto, lottos: List<Lotto>): Map<Prize, Int> {
        val prizeCounts = initializePrizeCounts()
        for (lotto in lottos) {
            val matchCount = winningLotto.countMatchingNumbers(lotto)
            val hasBonusNumber = winningLotto.isBonusNumberMatchedBy(lotto)
            val prize = Prize.of(matchCount, hasBonusNumber)
            prizeCounts.merge(prize, 1, Int::plus)
        }
        return prizeCounts
    }

    private fun initializePrizeCounts(): EnumMap<Prize, Int> =
        EnumMap<Prize, Int>(Prize::class.java).apply { Prize.entries.forEach { put(it, 0) } }

    fun calculateRateOfReturn(prizeCounts: Map<Prize, Int>, purchaseAmount: LottoPurchaseAmount): Double {
        val totalWinningAmount = prizeCounts.entries.sumOf { (prize, count) -> prize.winningAmount * count }
        return purchaseAmount.calculateRateOfReturn(totalWinningAmount)
    }
}
