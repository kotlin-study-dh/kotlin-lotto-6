package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class LottoExchangerTest {

    @Test
    fun `throw an exception when the purchase amount is not divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            LottoExchanger().purchase(999)
        }
    }

    @Test
    fun `lotto is one ticket for every 1,000 won`() {
        assertEquals(LottoExchanger().purchase(2000), 2)
    }
}