package lotto.domain

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
}