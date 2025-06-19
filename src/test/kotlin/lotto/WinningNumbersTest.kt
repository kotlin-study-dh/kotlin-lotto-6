package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    @Test
    fun `verify `() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1)
        }
    }
}