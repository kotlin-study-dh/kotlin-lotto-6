package lotto

import lotto.input.ConsoleInput
import lotto.output.ConsoleOutput

fun main() {
    val lottoGame = LottoGame(ConsoleInput(), ConsoleOutput())
    lottoGame.start()
}
