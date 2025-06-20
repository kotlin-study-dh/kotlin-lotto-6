package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningNumbersTest {

    @Test
    fun `verify duplicate lottoNumber and bonusNumber`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(Lotto(listOf(1, 2, 3, 4, 5, 6)), 1)
        }
    }

    @ParameterizedTest
    @MethodSource("matchWinningNumbers")
    fun `verify calculating matching number with winningNumber`(
        winningLotto: List<Int>,
        bonusNumber: Int,
        expected: Int
    ) {
        val winningNumbers = WinningNumbers(Lotto(winningLotto), bonusNumber)
        val inputLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThat(winningNumbers.calculateMatchingNumber(Lotto(inputLottoNumbers))).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun matchWinningNumbers() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, 6),
            Arguments.of(listOf(2, 3, 4, 5, 6, 7), 8, 5),
            Arguments.of(listOf(3, 4, 5, 6, 7, 8), 9, 4),
            Arguments.of(listOf(4, 5, 6, 7, 8, 9), 10, 3),
            Arguments.of(listOf(5, 6, 7, 8, 9, 10), 11, 2),
            Arguments.of(listOf(6, 7, 8, 9, 10, 11), 12, 1),
            Arguments.of(listOf(7, 8, 9, 10, 11, 12), 13, 0)
        )
    }
}
