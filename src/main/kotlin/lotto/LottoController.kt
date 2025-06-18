package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto
import lotto.domain.Prize
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(val input: InputView, val output: OutputView) {

    fun run() {
        val purchaseAmount = input.readPurchaseAmount()

        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw IllegalArgumentException("purchase amount has to be divided by 1000.")
        }
        val lottoCount = purchaseAmount / PURCHASE_AMOUNT_UNIT

        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(Lotto(numbers))
        }
        output.printGeneratedLottos(lottos)

        val winningNumbers = input.readWinningNumbers()
        val bonusNumber = input.readBonusNumber()

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