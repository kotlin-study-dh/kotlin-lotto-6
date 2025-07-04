package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoRankTest {

    @ParameterizedTest
    @MethodSource("rankResource")
    fun `verify returning valid rank`(
        matchCounts: Int,
        hasBonus: Boolean,
        expected: LottoRank
    ) {
        assertThat(LottoRank.getRank(matchCounts, hasBonus)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun rankResource() = listOf(
            Arguments.of(6, false, LottoRank.SIX_MATCH),
            Arguments.of(5, true, LottoRank.FIVE_BONUS_MATCH),
            Arguments.of(5, false, LottoRank.FIVE_MATCH),
            Arguments.of(4, false, LottoRank.FOUR_MATCH),
            Arguments.of(3, false, LottoRank.THREE_MATCH),
            Arguments.of(2, false, LottoRank.NONE_MATCH)
        )
    }
}
