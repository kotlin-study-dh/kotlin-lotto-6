package lotto.domain

import org.assertj.core.api.Assertions.assertThat
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
    fun `counts matching numbers correctly`() {
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

        val lotto = Lotto(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(8),
                LottoNumber.from(9),
                LottoNumber.from(10)
            )
        )

        // when
        val matchCount = winningLotto.countMatchingNumbers(lotto)

        // then
        assertThat(matchCount).isEqualTo(3)
    }

    @Test
    fun `true when bonus number is matched by lotto`() {
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

        val lotto = Lotto(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                bonusNumber
            )
        )

        // when
        val isBonusMatched = winningLotto.isBonusNumberMatchedBy(lotto)

        // then
        assertThat(isBonusMatched).isTrue()
    }

    @Test
    fun `false when bonus number is not matched by lotto`() {
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

        val lotto = Lotto(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(8)
            )
        )

        // when
        val isBonusMatched = winningLotto.isBonusNumberMatchedBy(lotto)

        // then
        assertThat(isBonusMatched).isFalse()
    }
}
