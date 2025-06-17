package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPurchaseAmountTest {
    @Test
    fun `fails to create LottoPurchaseAmount with amount less than 1000`() {
        // given
        val invalidAmount = 999

        // when & then
        assertThatThrownBy { LottoPurchaseAmount(invalidAmount) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Purchase amount must be greater than 1000.")
    }

    @Test
    fun `fails to create LottoPurchaseAmount with amount not divisible by 1000`() {
        // given
        val invalidAmount = 1500

        // when & then
        assertThatThrownBy { LottoPurchaseAmount(invalidAmount) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Purchase amount must be a multiple of 1000.")
    }

    @Test
    fun `succeeds in creating LottoPurchaseAmount with amount greater than or equal to 1000 and divisible by 1000`() {
        // given
        val validAmount = 2000

        // when
        val lottoPurchaseAmount = LottoPurchaseAmount(validAmount)

        // then
        assertThat(lottoPurchaseAmount.amount).isEqualTo(validAmount)
    }

    @Test
    fun `calculates purchase quantity correctly`() {
        // given
        val amount = 5000
        val lottoPurchaseAmount = LottoPurchaseAmount(amount)

        // when
        val purchaseQuantity = lottoPurchaseAmount.getPurchaseQuantity()

        // then
        assertThat(purchaseQuantity).isEqualTo(5)
    }

    @ParameterizedTest(name = "purchaseAmount={0}, winningAmount={1}, expectedRateOfReturn={2}")
    @CsvSource(
        "8000, 5000, 62.5",
        "9000, 10000, 111.1",
        "7000, 10000, 142.9",
    )
    fun `calculates rate of return correctly`(purchaseAmount: Int, winningAmount: Int, expectedRateOfReturn: Double) {
        // given
        val lottoPurchaseAmount = LottoPurchaseAmount(purchaseAmount)

        // when
        val rateOfReturn = lottoPurchaseAmount.calculateRateOfReturn(winningAmount)

        // then
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn)
    }
}
