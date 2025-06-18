package lotto.generator

import lotto.generator.NumbersGenerator.Companion.MAX_NUMBER
import lotto.generator.NumbersGenerator.Companion.MIN_NUMBER
import lotto.generator.NumbersGenerator.Companion.NUMBER_COUNT

class RandomNumbersGenerator : NumbersGenerator {

    override fun generate(): List<Int> {
        return (MIN_NUMBER..MAX_NUMBER).shuffled()
            .take(NUMBER_COUNT)
    }
}
