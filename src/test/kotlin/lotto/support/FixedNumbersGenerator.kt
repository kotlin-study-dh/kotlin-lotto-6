package lotto.support

import lotto.generator.NumbersGenerator
import lotto.generator.NumbersGenerator.Companion.MAX_NUMBER
import lotto.generator.NumbersGenerator.Companion.MIN_NUMBER
import lotto.generator.NumbersGenerator.Companion.NUMBER_COUNT

class FixedNumbersGenerator(
    private val fixedNumbers: List<Int>,
) : NumbersGenerator {
    init {
        require(fixedNumbers.size == NUMBER_COUNT) {
            "Fixed numbers must contain exactly $NUMBER_COUNT numbers."
        }
        require(fixedNumbers.all { it in MIN_NUMBER..MAX_NUMBER }) {
            "Fixed numbers must be between $MIN_NUMBER and $MAX_NUMBER."
        }
        require(fixedNumbers.distinct().size == fixedNumbers.size) {
            "Fixed numbers must be unique."
        }
    }

    override fun generate(): List<Int> {
        return fixedNumbers
    }
}
