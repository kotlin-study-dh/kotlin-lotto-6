package lotto.domain

import lotto.generator.NumbersGenerator

class LottoMachine {
    fun issueLottos(purchaseAmount: LottoPurchaseAmount, numbersGenerator: NumbersGenerator): List<Lotto> {
        val purchaseQuantity = purchaseAmount.getPurchaseQuantity()
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

    fun calculateRateOfReturn(prizeCounts: Map<Prize, Int>, purchaseAmount: LottoPurchaseAmount): Double {
        val totalWinningAmount = prizeCounts.entries.sumOf { (prize, count) -> prize.winningAmount * count }
        return purchaseAmount.calculateRateOfReturn(totalWinningAmount)
    }
}
