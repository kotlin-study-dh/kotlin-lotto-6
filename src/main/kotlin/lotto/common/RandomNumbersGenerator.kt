package lotto.common

import lotto.domain.LottoNumber

object RandomNumbersGenerator {

    fun generate(from: Int, to: Int, amount: Int): List<LottoNumber> {
        return (from..to).toMutableList()
            .also { it.shuffle() }
            .take(amount)
            .sorted()
            .map { LottoNumber(it) }
    }
}
