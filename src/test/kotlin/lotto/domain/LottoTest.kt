package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {

    @Test
    fun `verify LottoNumbers has only 6 number`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `verify LottoNumbers has unique number`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `verify LottoNumbers is between 1 and 45 `() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }
}
