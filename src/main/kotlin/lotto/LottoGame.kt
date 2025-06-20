package lotto

import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(private val input: InputView, private val output: OutputView) {

    fun start() {
        val lottos = generateLottos()
        val winningNumbers = input.readWinningNumber()
        showGameResult(lottos, winningNumbers)
    }

    private fun generateLottos(): Lottos {
        val purchaseAmount = input.readPurchaseAmount()
        val lottoCount = purchaseAmount.getLottoAmount()
        val lottos = Lottos.from(lottoCount)
        output.printGeneratedLottos(lottos)
        return lottos
    }

    private fun showGameResult(
        lottos: Lottos,
        winningNumbers: WinningNumbers,
    ) {
        val result = lottos.checkWinningResult(winningNumbers)
        output.printWinningStatistics(result.prizes)
        output.printRevenue(result.revenue)
    }
}