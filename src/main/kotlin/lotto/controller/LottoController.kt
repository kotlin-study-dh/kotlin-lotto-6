package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoPurchaseAmount
import lotto.domain.WinningLotto
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
        val winningLotto = getWinningLotto(lottoMachine)
        val prizeCounts = lottoMachine.getWinningResult(winningLotto, lottos)
        OutputView.printWinningStatistics(prizeCounts)
        val rateOfReturn = lottoMachine.calculateRateOfReturn(prizeCounts, lottoPurchaseAmount)
        OutputView.printRateOfReturn(rateOfReturn)
    }

    private fun getPurchaseAmount(): LottoPurchaseAmount {
        return retryOnFailure {
            val purchaseAmount = InputView.readPurchaseAmount()
            LottoPurchaseAmount(purchaseAmount)
        }
    }

    private fun getWinningLotto(lottoMachine: LottoMachine): WinningLotto {
        return retryOnFailure {
            val winningNumbers = InputView.readWinningNumbers()
            val bonusNumber = InputView.readBonusNumber()
            lottoMachine.issueWinningLotto(winningNumbers, bonusNumber)
        }
    }

    private fun <T> retryOnFailure(block: () -> T): T =
        runCatching<T> { return block() }
            .onFailure { e ->
                if (e is IllegalArgumentException) {
                    OutputView.printErrorMessage(e.message)
                    return retryOnFailure(block)
                }
            }.getOrThrow()
}
