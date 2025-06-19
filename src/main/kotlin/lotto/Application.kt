package lotto

import lotto.constant.LottoConstants
import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

fun <T> retryUntilValid(
    action: () -> T
): T {
    while (true) {
        try {
            return action()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}

fun main() {
    val lottos = retryUntilValid {
        val price = InputView.readPriceToBuy()
        Lottos.buy(price)
    }

    OutputView.printLottoNumbers(lottos)

    val lottoGame = retryUntilValid {
        val winningNumbers = retryUntilValid { WinningNumbers.ofNumbers(InputView.readWinningNumbers()) }
        val bonusNumber = retryUntilValid { LottoNumber(InputView.readBonusNumber()) }
        LottoGame(lottos, winningNumbers, bonusNumber)
    }

    OutputView.printGameResult(lottoGame.result(), lottos.size() * LottoConstants.LOTTO_PRICE)
}
