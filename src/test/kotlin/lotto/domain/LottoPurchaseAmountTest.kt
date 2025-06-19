package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoPurchaseAmountTest {

    @Test
    fun `throw exception when a value is not the multiples of 1,000`() {
        assertThatThrownBy{ LottoPurchaseAmount(1001) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

}