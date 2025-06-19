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

        val prizes = lottos.checkWinningResults(winningNumbers, bonusNumber)
        output.printWinningStatistics(prizes)

        val totalReward = prizes.sumOf { it.reward }
        val revenue =
            totalReward.toDouble() / purchaseAmount.value * 100
        output.printRevenue(revenue)
    }
}