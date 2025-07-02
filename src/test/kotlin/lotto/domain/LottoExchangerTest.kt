package lotto.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
        Assertions.assertEquals(exchanger.purchase().size, 2)
    }

    @Test
    fun `purchase_amount should be greater than 0`() {
        assertThrows<IllegalArgumentException> {
            LottoExchanger(-1)
        }
    }

    @Test
    fun `calculate yield rate`() {
        // given
        val purchaseAmount = 2000
        val exchanger = LottoExchanger(purchaseAmount)

        // when
        val yieldRate = exchanger.yieldRate(listOf(Score.THIRD))

        // then
        Assertions.assertEquals(Score.THIRD.prize / purchaseAmount.toDouble() * 100, yieldRate)
    }
}