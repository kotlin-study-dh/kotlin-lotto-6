package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoNumber
import lotto.domain.LottoPurchaseAmount

class InputView {
    fun readPurchaseAmount(): LottoPurchaseAmount = retry {
        println("구입금액을 입력해 주세요.")
        return LottoPurchaseAmount(Console.readLine().toInt())
    }

    fun readWinningNumbers(): List<LottoNumber> = retry {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine().split(",").map { LottoNumber(it.toInt()) }
    }

    fun readBonusNumber(): LottoNumber = retry {
        println("보너스 번호를 입력해 주세요.")
        return LottoNumber(Console.readLine().toInt())
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