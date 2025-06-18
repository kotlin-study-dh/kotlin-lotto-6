package lotto.domain

import lotto.domain.number.NumberGenerator
import lotto.domain.number.Numbers

class LottoIssuer(private val numberGenerator: NumberGenerator) {

    companion object {
        const val LOTTO_SIZE = 6
    }

    fun issue(): Numbers {
        return Numbers.fromInts(*numberGenerator.generate(LOTTO_SIZE))
    }
}