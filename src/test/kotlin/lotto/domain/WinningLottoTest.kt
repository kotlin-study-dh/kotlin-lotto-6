package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `fails to create WinningLotto with bonus number in winning numbers`() {
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
        val bonusNumber = LottoNumber.from(1)

        // when & then
        assertThatThrownBy() { WinningLotto(winningNumbers, bonusNumber) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus number must not be included in the winning numbers.")
    }

    @Test
    fun `succeeds in creating WinningLotto with bonus number not in winning numbers`() {
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

        // when
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        // then
        SoftAssertions.assertSoftly { softly ->
            softly.assertThat(winningLotto.winningNumbers.getSortedNumbers())
                .containsExactlyInAnyOrderElementsOf(winningNumbers.getSortedNumbers())
            softly.assertThat(winningLotto.bonusNumber).isEqualTo(bonusNumber)
        }
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

        // when
        val prizeCounts = winningLotto.compareTo(lottos)

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
}
