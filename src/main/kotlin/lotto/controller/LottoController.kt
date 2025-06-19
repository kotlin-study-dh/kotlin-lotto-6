package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoPurchaseAmount
import lotto.generator.NumbersGenerator
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoController(
    private val numbersGenerator: NumbersGenerator,
) {
    fun start() {
        val lottoMachine = LottoMachine()
        val lottoPurchaseAmount = getPurchaseAmount()
        val lottos = lottoMachine.issueLottos(lottoPurchaseAmount, numbersGenerator)
        OutputView.printLottos(lottos)
        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()
        val winningLotto = lottoMachine.issueWinningLotto(winningNumbers, bonusNumber)
        val prizeCounts = lottoMachine.getWinningResult(winningLotto, lottos)
        OutputView.printWinningStatistics(prizeCounts)
        val rateOfReturn = lottoMachine.calculateRateOfReturn(prizeCounts, lottoPurchaseAmount)
        OutputView.printRateOfReturn(rateOfReturn)
    }

    private fun getPurchaseAmount(): LottoPurchaseAmount =
        runCatching<LottoPurchaseAmount> {
            val purchaseCount = InputView.readPurchaseAmount()
            return LottoPurchaseAmount(purchaseCount)
        }.onFailure { e ->
            if (e is IllegalArgumentException) {
                OutputView.printErrorMessage(e.message)
                return getPurchaseAmount()
            }
        }.getOrThrow()
}
