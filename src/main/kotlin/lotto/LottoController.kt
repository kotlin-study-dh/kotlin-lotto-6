package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.ErrorHandling.Companion.retry
import lotto.domain.Lotto
import lotto.domain.Lottos
import lotto.domain.Prize
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

        val prizes = lottos.map { it.match(winningNumbers) }
                .mapNotNull { Prize.of(it, winningNumbers.contains(bonusNumber)) }
        output.printWinningStatistics(prizes)

        val totalReward = prizes.sumOf { it.reward }
        val revenue = totalReward.toDouble() / purchaseAmount * 100
        output.printRevenue(revenue)
    }

    companion object {
        const val PURCHASE_AMOUNT_UNIT = 1_000
    }
}