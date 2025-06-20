package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    @Test
    fun `verify duplicate lottoNumber and bonusNumber`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(Lotto(listOf(1, 2, 3, 4, 5, 6)), 1)
        }
    }
}
