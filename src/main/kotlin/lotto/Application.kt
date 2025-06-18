package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val output = OutputView()
    try {
        val lottoController = LottoController(InputView(), output)
        lottoController.run()
    } catch (e: Exception) {
        output.printError(e)
    }
}
