package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoRankTest {

    @Test
    fun `6 matches -- first prize`() {
        assert(LottoRank.of(6, false) == LottoRank.FIRST)
    }

    @Test
    fun `5 matches 1 bonus -- second prize`() {
        assert(LottoRank.of(5, true) == LottoRank.SECOND)
    }

    @Test
    fun `5 matches 0 bonus -- third prize`() {
        assert(LottoRank.of(5, false) == LottoRank.THIRD)
    }

    @Test
    fun `4 matches 0 to 1 bonus -- fourth prize`() {
        assertAll(
            { assert(LottoRank.of(4, true) == LottoRank.FOURTH) },
            { assert(LottoRank.of(4, false) == LottoRank.FOURTH) }
        )
    }

    @Test
    fun `3 matches 0 to 1 bonus -- fifth prize`() {
        assertAll(
            { assert(LottoRank.of(3, true) == LottoRank.FIFTH) },
            { assert(LottoRank.of(3, false) == LottoRank.FIFTH) }
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 1, 0])
    fun `no prize`(matchCount: Int) {
        assertAll(
            { assert(LottoRank.of(matchCount, true) == LottoRank.NO_PRIZE) },
            { assert(LottoRank.of(matchCount, false) == LottoRank.NO_PRIZE) },
        )
    }
}
