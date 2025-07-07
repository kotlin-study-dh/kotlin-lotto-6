package lotto.domain

import org.junit.jupiter.api.Test

class LottoGameResultTest {

    @Test
    fun `FIRST, SECOND, NO_PRIZE - prize money is 2_030_000_000`() {
        val result = LottoGameResult(listOf(LottoRank.FIRST, LottoRank.SECOND, LottoRank.NO_PRIZE))
        assert(result.prizeMoney() == 2_030_000_000L)
    }

    @Test
    fun `add the rank of FIRST for twice - then the map has 2 counts for FIRST and 0 for others`() {
        val result = LottoGameResult(listOf(LottoRank.FIRST, LottoRank.FIRST))

        assert(result.rankCounts == mapOf(
            LottoRank.FIRST to 2,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 0,
            LottoRank.FOURTH to 0,
            LottoRank.FIFTH to 0,
            LottoRank.NO_PRIZE to 0,
        ))
    }
}
