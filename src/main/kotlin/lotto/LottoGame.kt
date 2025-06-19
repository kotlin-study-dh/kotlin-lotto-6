package lotto

import lotto.domain.LottoExchanger
import lotto.domain.LottoInspector
import lotto.domain.number.BonusNumber
import lotto.domain.number.Numbers
import lotto.input.ConsoleInput
import lotto.input.retryInput
import lotto.output.ConsoleOutput

class LottoGame(
    val input: ConsoleInput,
    val output: ConsoleOutput
) {

    fun start() {
        val (exchanger, guessingNumbers) = retryInput { purchaseLottoTickets() }
        val (winningNumbers, bonusNumber) = retryInput { createWinningNumbers() }
        proceedLottery(winningNumbers, bonusNumber, guessingNumbers, exchanger)
    }

    private fun purchaseLottoTickets(): Pair<LottoExchanger, List<Numbers>> {
        val purchaseAmount = input.purchaseRequest()
        val exchanger = LottoExchanger(purchaseAmount)
        val guessingNumbers = exchanger.purchase()
        output.purchaseResponse(guessingNumbers)
        return Pair(exchanger, guessingNumbers)
    }

    private fun createWinningNumbers(): Pair<Numbers, BonusNumber> {
        val winningNumbers = Numbers.fromInts(*input.winningNumberRequest().toIntArray())
        val bonusNumber = BonusNumber(input.bonusNumberRequest())
        return Pair(winningNumbers, bonusNumber)
    }

    private fun proceedLottery(
        winningNumbers: Numbers,
        bonusNumber: BonusNumber,
        guessingNumbers: List<Numbers>,
        exchanger: LottoExchanger
    ) {
        val inspector = LottoInspector(winningNumbers, bonusNumber)
        val scores = inspector.inspect(guessingNumbers)
        output.winningStatisticsResponse(scores)
        output.reteOfReturnResponse(exchanger.yieldRate(scores))
    }
}