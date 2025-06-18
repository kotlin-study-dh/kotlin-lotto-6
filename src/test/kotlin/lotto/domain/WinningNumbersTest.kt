package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.WinningNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `make sure the numbers are not duplicated`() {
        Assertions.assertThatCode { WinningNumbers.fromInts(1, 2, 3, 4, 5, 6) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throw exception if numbers are duplicate`() {
        Assertions.assertThatThrownBy { WinningNumbers.fromInts(1, 2, 3, 4, 5, 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `the selection must include 6 winning numbers`() {
        Assertions.assertThatCode { WinningNumbers.fromInts(1, 2, 3, 4, 5, 6) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throw exception if selection numbers are not included 6`() {
        Assertions.assertThatThrownBy { WinningNumbers.fromInts(1, 2, 3, 4, 5, 6, 7) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `returns the number of overlapping elements in the array`() {
        // given
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)
        val otherNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 7)

        // when
        val match = winningNumbers.match(otherNumbers)

        // then
        Assertions.assertThat(match).isEqualTo(5)
    }

    @Test
    fun `check the match with bonus number`() {
        // given
        val bonusNumber = BonusNumber(1)
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)

        // when
        val match = winningNumbers.match(bonusNumber)

        // then
        Assertions.assertThat(match).isTrue
    }

    @Test
    fun `check the does not match with bonus number`() {
        // given
        val bonusNumber = BonusNumber(7)
        val winningNumbers = WinningNumbers.fromInts(1, 2, 3, 4, 5, 6)

        // when
        val match = winningNumbers.match(bonusNumber)

        // then
        Assertions.assertThat(match).isFalse
    }
}