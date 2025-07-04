package lotto

import lotto.domain.Lotto
import lotto.domain.WinningNumbers
import lotto.domain.WinningResult
import lotto.view.*

class LottoGame {

    fun start() {
        val purchaseResult = getPurchaseResult()
        printPurchaseAmount(purchaseResult.lottos)
        val winningNumbers = getWinningNumbers()
        val winningResult = getWinningResult(purchaseResult, winningNumbers)
        printWinningStatus(winningResult, purchaseResult.purchaseAmount)
    }

    private fun getPurchaseResult(): PurchaseResult {
        return retryLogic {
            val purchaseAmount = readPurchaseAmount()
            val lottos = List(purchaseAmount) {
                Lotto(LottoNumbersGenerator.generate())
            }
            PurchaseResult(purchaseAmount, lottos)
        }
    }

    private fun getWinningNumbers(): WinningNumbers {
        val winningNumbers = retryLogic {
            WinningNumbers(
                Lotto(readWinningNumbers()), readBonusNumber()
            )
        }
        return winningNumbers
    }

    private fun getWinningResult(
        purchaseResult: PurchaseResult,
        winningNumbers: WinningNumbers
    ): WinningResult = WinningResult(purchaseResult.lottos, winningNumbers)

    private inline fun <T> retryLogic(crossinline block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: Exception) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    data class PurchaseResult(val purchaseAmount: Int, val lottos: List<Lotto>)
}
