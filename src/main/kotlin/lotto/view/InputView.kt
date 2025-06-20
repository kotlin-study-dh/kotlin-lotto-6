package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoNumber
import lotto.domain.LottoPurchaseAmount
import lotto.domain.WinningNumbers

class InputView {
    fun readPurchaseAmount(): LottoPurchaseAmount = retry {
        println("구입금액을 입력해 주세요.")
        return LottoPurchaseAmount(Console.readLine().toInt())
    }

    fun readWinningNumber(): WinningNumbers {
        val winningNumbers = readWinningNumbers()
        return addBonusNumber(winningNumbers)
    }

    private fun readWinningNumbers(): List<LottoNumber> = retry {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine().split(",").map { LottoNumber(it.toInt()) }
    }

    private fun addBonusNumber(winningNumbers: List<LottoNumber>): WinningNumbers = retry {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = LottoNumber(Console.readLine().toInt())
        return WinningNumbers(winningNumbers, bonusNumber)
    }

    companion object {
        inline fun <T> retry(
            block: () -> T
        ): T {
            while (true) {
                try {
                    return block()
                } catch (exception: Exception) {
                    println("[ERROR] ${exception.message}")
                }
            }
        }
    }
}