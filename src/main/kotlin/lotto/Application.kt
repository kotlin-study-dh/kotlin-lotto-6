package lotto

import lotto.controller.LottoController
import lotto.generator.RandomNumbersGenerator

fun main() {
    val numbersGenerator = RandomNumbersGenerator()
    val lottoController = LottoController(numbersGenerator)
    lottoController.start()
}
