package lotto

import lotto.ErrorHandling.Companion.retry
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(val input: InputView, val output: OutputView) {

    fun run() {
        val purchaseAmount = retry(input::readPurchaseAmount, output::printError)
        val lottoCount = purchaseAmount.count

        val lottos = Lottos.from(lottoCount)
        output.printGeneratedLottos(lottos)

        val winningNumbers = retry(input::readWinningNumbers, output::printError)
        val bonusNumber = retry(input::readBonusNumber, output::printError)

        val result = lottos.checkWinningResult(winningNumbers, bonusNumber)
        output.printWinningStatistics(result.prizes)
        output.printRevenue(result.revenue)
    }
}