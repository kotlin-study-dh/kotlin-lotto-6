package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.Numbers
import org.junit.jupiter.api.Test

class LottoInspectorTest {

    @Test
    fun `determine the Lotto grade first case`() {
        // given
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(7)
        val inspector = LottoInspector(numbers, bonusNumber)

        // when
        val score = inspector.inspect(listOf(guessingNumbers))[0]

        // then
        assert(score === Score.FIRST)
    }

    @Test
    fun `determine the Lotto grade second case`() {
        // given
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 7)
        val guessingNumbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(6)
        val inspector = LottoInspector(numbers, bonusNumber)

        // when
        val score = inspector.inspect(listOf(guessingNumbers))[0]

        // then
        assert(score === Score.SECOND)
    }

    @Test
    fun `determine the Lotto grade third case`() {
        // given
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = Numbers.fromInts(1, 2, 3, 4, 5, 8)
        val bonusNumber = BonusNumber(9)
        val inspector = LottoInspector(numbers, bonusNumber)

        // when
        val score = inspector.inspect(listOf(guessingNumbers))[0]

        // then
        assert(score === Score.THIRD)
    }

    @Test
    fun `determine the Lotto grade fourth case`() {
        // given
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = Numbers.fromInts(1, 2, 3, 5, 8, 9)
        val bonusNumber = BonusNumber(10)
        val inspector = LottoInspector(numbers, bonusNumber)

        // when
        val score = inspector.inspect(listOf(guessingNumbers))[0]

        // then
        assert(score === Score.FOURTH)
    }

    @Test
    fun `determine the Lotto grade fifth case`() {
        // given
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = Numbers.fromInts(1, 2, 3, 7, 8, 9)
        val bonusNumber = BonusNumber(10)
        val inspector = LottoInspector(numbers, bonusNumber)

        // when
        val score = inspector.inspect(listOf(guessingNumbers))[0]

        // then
        assert(score === Score.FIFTH)
    }
}