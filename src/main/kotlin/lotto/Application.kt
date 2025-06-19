package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val input = InputView()
    val output = OutputView()
    val lottoGame = LottoGame(input, output)
    try {
        lottoGame.start()
    } catch (e: Exception) {
        output.printError(e)
    }
}
