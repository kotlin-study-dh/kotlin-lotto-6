package lotto.domain

import lotto.support.FixedNumbersGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(
        "1000, 1",
        "5000, 5",
        "11000, 11",
        "200000, 200",
    )
    fun `issue lottos based on purchase amount`(amount: Int, expectedCount: Int) {
        // given
        val purchaseAmount = LottoPurchaseAmount(amount)
        val numbersGenerator = FixedNumbersGenerator(
            fixedNumbers = listOf(1, 2, 3, 4, 5, 6)
        )
        val lottoMachine = LottoMachine()

        // when
        val lottos = lottoMachine.issueLottos(purchaseAmount, numbersGenerator)

        // then
        assertThat(lottos).hasSize(expectedCount)
    }

    @Test
    fun `calculate rate of return based on prize counts and purchase amount`() {
        // given
        val purchaseAmount = LottoPurchaseAmount(15000)
        val prizeCounts = mapOf(
            Prize.FOURTH to 1,
            Prize.FIFTH to 3
        )
        val lottoMachine = LottoMachine()

        // when
        val rateOfReturn = lottoMachine.calculateRateOfReturn(prizeCounts, purchaseAmount)

        // then
        assertThat(rateOfReturn).isEqualTo(433.3)
    }
}
