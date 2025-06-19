package lotto

import lotto.ErrorHandling.Companion.retry
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(val input: InputView, val output: OutputView) {

    fun start() {
        val lottos = generateLottos()
        val (winningNumbers, bonusNumber) = readWinningNumbers()
        showGameResult(lottos, winningNumbers, bonusNumber)
    }

    private fun generateLottos(): Lottos {
        val purchaseAmount = retry(input::readPurchaseAmount, output::printError)
        val lottoCount = purchaseAmount.getLottoAmount()
        val lottos = Lottos.from(lottoCount)
        output.printGeneratedLottos(lottos)
        return lottos
    }

    private fun readWinningNumbers(): Pair<List<LottoNumber>, LottoNumber> {
        val winningNumbers = retry(input::readWinningNumbers, output::printError)
        val bonusNumber = retry(input::readBonusNumber, output::printError)
        return Pair(winningNumbers, bonusNumber)
    }

    private fun showGameResult(
        lottos: Lottos,
        winningNumbers: List<LottoNumber>,
        bonusNumber: LottoNumber
    ) {
        val result = lottos.checkWinningResult(winningNumbers, bonusNumber)
        output.printWinningStatistics(result.prizes)
        output.printRevenue(result.revenue)
    }
}