package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `throw exception when the size of winning numbers is not lotto size`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5).map { LottoNumber(it) }

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            WinningNumbers(winningNumbers, LottoNumber(6))
        }
    }

    @Test
    fun `throw exception when the size of winning numbers is not unique`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 5)
            .map { LottoNumber(it) }

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            WinningNumbers(winningNumbers, LottoNumber(6))
        }
    }

    @Test
    fun `throw exception when bonus number is in winning numbers`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
            .map { LottoNumber(it) }
        val bonusNumber = LottoNumber(6)

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            WinningNumbers(winningNumbers, bonusNumber)
        }

    }

}