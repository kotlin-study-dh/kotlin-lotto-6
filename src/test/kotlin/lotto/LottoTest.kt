package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoRank
import lotto.domain.WinningNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.ofNumbers(1, 2, 3, 4, 5, 6, 7)
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.ofNumbers(1, 2, 3, 4, 5, 5)
        }
    }

    @Test
    fun `calculate rank - FIRST`() {
        // given
        val lotto = Lotto.ofNumbers(1, 2, 3, 4, 5, 6)

        // when
        val result = lotto.calculateRank(
            WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5, 6)),
            LottoNumber(10)
        )

        // then
        assert(result == LottoRank.FIRST)
    }

    @Test
    fun `calculate rank - SECOND`() {
        // given
        val lotto = Lotto.ofNumbers(1, 2, 3, 4, 5, 6)

        // when
        val result = lotto.calculateRank(
            WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5, 10)),
            LottoNumber(6)
        )

        // then
        assert(result == LottoRank.SECOND)
    }

    @Test
    fun `calculate rank - THIRD`() {
        // given
        val lotto = Lotto.ofNumbers(1, 2, 3, 4, 5, 6)

        // when
        val result = lotto.calculateRank(
            WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5, 10)),
            LottoNumber(20)
        )

        // then
        assert(result == LottoRank.THIRD)
    }

    @Test
    fun `calculate rank - FOURTH`() {
        // given
        val lotto = Lotto.ofNumbers(1, 2, 3, 4, 5, 6)

        // when
        val result = lotto.calculateRank(
            WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 15, 16)),
            LottoNumber(20)
        )

        // then
        assert(result == LottoRank.FOURTH)
    }

    @Test
    fun `calculate rank - FIFTH`() {
        // given
        val lotto = Lotto.ofNumbers(1, 2, 3, 4, 5, 6)

        // when
        val result = lotto.calculateRank(
            WinningNumbers.ofNumbers(listOf(1, 2, 3, 14, 15, 16)),
            LottoNumber(20)
        )

        // then
        assert(result == LottoRank.FIFTH)
    }

    @Test
    fun `calculate rank - NO_PRIZE`() {
        // given
        val lotto = Lotto.ofNumbers(1, 2, 3, 4, 5, 6)

        // when
        val result = lotto.calculateRank(
            WinningNumbers.ofNumbers(listOf(1, 2, 13, 14, 15, 16)),
            LottoNumber(20)
        )

        // then
        assert(result == LottoRank.NO_PRIZE)
    }

}
