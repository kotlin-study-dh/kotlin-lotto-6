package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `returns matched count when given winning numbers`() { // todo: improve
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }

        val matchedCount = lotto.match(winningNumbers)

        assert(matchedCount == 6)
    }

    @Test
    fun `return if it contains a specific number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val contains = lotto.contains(LottoNumber(1))

        assert(contains)
    }
}