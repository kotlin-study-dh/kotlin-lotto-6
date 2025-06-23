package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.math.BigDecimal

class WinningResultTest {

    @Test
    fun `verify calculating WinningResult`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 40, 41, 42)),
            Lotto(listOf(3, 4, 5, 6, 34, 35))
        )
        val winningNumbers = WinningNumbers(Lotto(listOf(1, 2, 3, 4, 5, 6)), 45)
        val winningResult = WinningResult(lottos, winningNumbers)

        assertAll({
            assertThat(winningResult.getByRank(LottoRank.THREE_MATCH)).isEqualTo(1)
            assertThat(winningResult.getByRank(LottoRank.FOUR_MATCH)).isEqualTo(1)
            assertThat(winningResult.getByRank(LottoRank.FIVE_MATCH)).isEqualTo(0)
        })
    }

    @Test
    fun `verify calculating profit rate`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 41, 42, 43)))
        val winningNumbers = WinningNumbers(Lotto(listOf(1, 2, 3, 4, 5, 6)), 45)
        val winningResult = WinningResult(lottos, winningNumbers)
        assertThat(winningResult.calculateProfitRate(15)).isEqualTo(BigDecimal("33.3"))
    }

    companion object {
        val expectedWinningResult = mapOf(
            LottoRank.THREE_MATCH to 1,
            LottoRank.FOUR_MATCH to 1,
            LottoRank.FIVE_MATCH to 0,
            LottoRank.FIVE_BONUS_MATCH to 0,
            LottoRank.SIX_MATCH to 0,
            LottoRank.NONE_MATCH to 0
        )
    }
}
