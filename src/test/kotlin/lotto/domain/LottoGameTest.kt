package lotto.domain

import org.junit.jupiter.api.Test

class LottoGameTest {

    @Test
    fun `get the overall result for all the lottos`() {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1st
                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1st
                Lotto(listOf(1, 2, 3, 4, 5, 45)), // 2nd
                Lotto(listOf(1, 2, 3, 4, 5, 16)), // 3rd
                Lotto(listOf(1, 2, 3, 14, 15, 16)), // 5th
                Lotto(listOf(11, 12, 13, 14, 15, 16)), // no-prize
            )
        )

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 45
        val lottoGame = LottoGame(lottos, winningNumbers, bonusNumber)

        // when
        val result = lottoGame.result()

        // then
        assert(
            result == mapOf(
                LottoRank.FIRST to 2,
                LottoRank.SECOND to 1,
                LottoRank.THIRD to 1,
                LottoRank.FIFTH to 1,
                LottoRank.NO_PRIZE to 1,
            )
        )
    }
}
