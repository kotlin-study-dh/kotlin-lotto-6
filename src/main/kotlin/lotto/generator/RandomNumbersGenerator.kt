package lotto.generator

import camp.nextstep.edu.missionutils.Randoms
import lotto.generator.NumbersGenerator.Companion.MAX_NUMBER
import lotto.generator.NumbersGenerator.Companion.MIN_NUMBER
import lotto.generator.NumbersGenerator.Companion.NUMBER_COUNT

class RandomNumbersGenerator : NumbersGenerator {

    override fun generate(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)
    }
}
