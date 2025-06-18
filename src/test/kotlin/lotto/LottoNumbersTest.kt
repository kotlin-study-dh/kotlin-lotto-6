package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    fun `verify LottoNumbers has only 6 number`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `verify LottoNumbers has unique number`() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `verify LottoNumbers is between 1 and 45 `() {
        assertThrows<IllegalArgumentException> {
            LottoNumbers(listOf(1,2,3,4,5))
        }
    }
}