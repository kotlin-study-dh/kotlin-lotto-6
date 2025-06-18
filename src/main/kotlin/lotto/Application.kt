package lotto

import lotto.domain.LottoGame
import lotto.domain.Lottos
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val price = InputView.readPriceToBuy()
    val lottos = Lottos(price / 1000) // TODO: remove magic number
    OutputView.printLottoNumbers(lottos)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()
    val lottoGame = LottoGame(lottos, winningNumbers, bonusNumber)
    OutputView.printGameResult(lottoGame)
}
