package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.WinningNumbers
import org.assertj.core.api.Assertions
import kotlin.test.Test

class LottoInspectorTest {

    @Test
    fun `determine the Lotto grade first case`() {
        // given
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(7)
        val inspector = LottoInspector(winningNumbers)

        // when
        val score = inspector.inspect(guessingNumbers, bonusNumber)

        // then
        Assertions.assertThat(score).isSameAs(Score.FIRST)
    }

    @Test
    fun `determine the Lotto grade second case`() {
        // given
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 7)
        val bonusNumber = BonusNumber(6)
        val inspector = LottoInspector(winningNumbers)

        // when
        val score = inspector.inspect(guessingNumbers, bonusNumber)

        // then
        Assertions.assertThat(score).isSameAs(Score.SECOND)
    }

    @Test
    fun `determine the Lotto grade third case`() {
        // given
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 8)
        val bonusNumber = BonusNumber(9)
        val inspector = LottoInspector(winningNumbers)

        // when
        val score = inspector.inspect(guessingNumbers, bonusNumber)

        // then
        Assertions.assertThat(score).isSameAs(Score.THIRD)
    }

    @Test
    fun `determine the Lotto grade fourth case`() {
        // given
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = WinningNumbers.fromInts(1, 2, 3, 5, 8, 9)
        val bonusNumber = BonusNumber(10)
        val inspector = LottoInspector(winningNumbers)

        // when
        val score = inspector.inspect(guessingNumbers, bonusNumber)

        // then
        Assertions.assertThat(score).isSameAs(Score.FOURTH)
    }

    @Test
    fun `determine the Lotto grade fifth case`() {
        // given
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)
        val guessingNumbers = WinningNumbers.fromInts(1, 2, 3, 7, 8, 9)
        val bonusNumber = BonusNumber(10)
        val inspector = LottoInspector(winningNumbers)

        // when
        val score = inspector.inspect(guessingNumbers, bonusNumber)

        // then
        Assertions.assertThat(score).isSameAs(Score.FIFTH)
    }
}