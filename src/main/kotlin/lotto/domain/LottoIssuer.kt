package lotto.domain

import lotto.domain.number.NumberGenerator
import lotto.domain.number.WinningNumbers

class LottoIssuer(val numberGenerator: NumberGenerator) {

    companion object {
        const val LOTTO_SIZE = 6
    }

    fun issue(): WinningNumbers {
        return WinningNumbers.fromInts(*numberGenerator.generate(LOTTO_SIZE))
    }
}