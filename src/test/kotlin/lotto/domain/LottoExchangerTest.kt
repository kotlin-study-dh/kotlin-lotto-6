package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class LottoExchangerTest {

    @Test
    fun `throw an exception when the purchase amount is not divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            LottoExchanger(999)
        }
    }

    @Test
    fun `lotto is one ticket for every 1,000 won`() {
        // given
        val exchanger = LottoExchanger(2000)

        // when & then
        assertEquals(exchanger.purchase(), 2)
    }

    @Test
    fun `calculate yield rate`() {
        // given
        val purchaseAmount = 2000
        val exchanger = LottoExchanger(purchaseAmount)

        // when
        val yieldRate = exchanger.yieldRate(listOf(Score.THIRD))

        // then
        assertEquals(Score.THIRD.prize / purchaseAmount, yieldRate)
    }
}