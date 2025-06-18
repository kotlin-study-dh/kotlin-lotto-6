package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottosTest {

    @Test
    fun `there must be at least one lotto`() {
        assertThrows<IllegalArgumentException>("At least one lotto has to be bought.") {
            Lottos(emptyList())
        }
    }

    @ParameterizedTest
    @ValueSource(longs = [-1000L, 0L])
    fun `can't buy lottos with negative or zero purchasing money`(price: Long) {
        assertThrows<IllegalArgumentException>("Purchasing price must be 1000 or greater.") {
            Lottos.buy(price)
        }
    }

    @Test
    fun `purchasing price must be divisible by lotto price`() {
        assertDoesNotThrow {
            Lottos.buy(2000)
        }

        assertThrows<IllegalArgumentException>("Purchasing price must be divisible by 1000.") {
            Lottos.buy(2001)
        }
    }
}
