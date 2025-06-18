package lotto

import lotto.domain.Lotto
import lotto.domain.LottoResult
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `calculate result - 5 number matches, bonus match FALSE`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val result = lotto.calculateResult(listOf(1, 2, 3, 4, 5, 7), 45)

        // then
        assert(result == LottoResult(matchCount = 5, matchesBonus = false))
    }

    @Test
    fun `calculate result - 0 number matches, bonus match TRUE`() {
        // given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // when
        val result = lotto.calculateResult(listOf(11, 12, 13, 14, 15, 16), 1)

        // then
        assert(result == LottoResult(matchCount = 0, matchesBonus = true))
    }
}
