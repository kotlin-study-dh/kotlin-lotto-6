package lotto.domain

import lotto.support.FixedNumbersGenerator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
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
    fun `returns correct prize counts for multiple lotto`() {
        // given
        val winningNumbers = Lotto(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
            )
        )
        val bonusNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val lottos = listOf(
            // FIRST
            Lotto(
                listOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6)
                )
            ),
            // SECOND
            Lotto(
                listOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    bonusNumber
                )
            ),
            // FIFTH
            Lotto(
                listOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(7),
                    LottoNumber.from(8),
                    LottoNumber.from(9)
                )
            ),
            // NONE
            Lotto(
                listOf(
                    LottoNumber.from(30),
                    LottoNumber.from(31),
                    LottoNumber.from(32),
                    LottoNumber.from(33),
                    LottoNumber.from(34),
                    LottoNumber.from(35)
                )
            ),
            // NONE
            Lotto(
                listOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(12),
                    LottoNumber.from(13),
                    LottoNumber.from(14),
                    LottoNumber.from(15)
                )
            )
        )
        val lottoMachine = LottoMachine()

        // when
        val prizeCounts = lottoMachine.getWinningResult(winningLotto, lottos)

        // then
        SoftAssertions.assertSoftly { softly ->
            softly.assertThat(prizeCounts[Prize.FIRST]).isEqualTo(1)
            softly.assertThat(prizeCounts[Prize.SECOND]).isEqualTo(1)
            softly.assertThat(prizeCounts[Prize.THIRD]).isEqualTo(0)
            softly.assertThat(prizeCounts[Prize.FOURTH]).isEqualTo(0)
            softly.assertThat(prizeCounts[Prize.FIFTH]).isEqualTo(1)
            softly.assertThat(prizeCounts[Prize.NONE]).isEqualTo(2)
        }
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
