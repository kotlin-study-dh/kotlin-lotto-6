package lotto

class LottoGame {

    fun start() {
        val purchaseResult = getPurchaseResult()
        printPurchaseAmount(purchaseResult.lottos)
        val winningNumbers = getWinningNumbers()
        val winningResult = getWinningResult(purchaseResult, winningNumbers)
        printWinningStatus(winningResult, purchaseResult.purchaseAmount)
    }

    private fun getPurchaseResult(): PurchaseResult {
        val purchaseResult = retryLogic {
            val purchaseAmount = readPurchaseAmount()
            val lottos = mutableListOf<Lotto>()
            for (i in 1..purchaseAmount) {
                lottos.add(Lotto(LottoNumbersGenerator.generate()))
            }
            PurchaseResult(purchaseAmount, lottos)
        }
        return purchaseResult
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

    private inline fun <T> retryLogic(block: () -> T): T {
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