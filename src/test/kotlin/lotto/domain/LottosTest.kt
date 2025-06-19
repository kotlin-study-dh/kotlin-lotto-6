package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `generates lottos from lotto count`() {
        val lottoCount = 3
        val lottos = Lottos.from(lottoCount)

        assertThat(lottos.items.size).isEqualTo(3)
    }

    @Test
    fun `return prizes with winning numbers`() {
        // given
        val fakeWinningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val lottos = Lottos(listOf(Lotto(fakeWinningNumbers), Lotto(listOf(9, 10, 11, 12, 13, 14))))
        val winningNumbers = fakeWinningNumbers.map {  LottoNumber(it) }
        val bonusNumber = LottoNumber(9)

        // when
        val prizes = lottos.checkWinningResults(winningNumbers, bonusNumber)

        // then
        assertThat(prizes).hasSize(1)
    }
}