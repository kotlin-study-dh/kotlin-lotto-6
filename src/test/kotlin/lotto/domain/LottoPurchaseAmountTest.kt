package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoPurchaseAmountTest {

    @Test
    fun `throw exception when a value is not the multiples of 1,000`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmount(1001)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-100, -1, 0])
    fun `throw exception when a value is not positive`(nonNegativeValue: Int) {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseAmount(nonNegativeValue)
        }
    }

}