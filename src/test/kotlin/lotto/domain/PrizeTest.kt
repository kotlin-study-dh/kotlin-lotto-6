package lotto.domain

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PrizeTest {
    @ParameterizedTest
    @MethodSource("prizeTestCases")
    fun `should return correct prize based on matchCount and bonusMatch`(
        matchCount: Int,
        bonusMatch: Boolean,
        expectedPrize: Prize
    ) {
        val result = Prize.of(matchCount, bonusMatch)
        assert(result == expectedPrize)
    }

    companion object {
        @JvmStatic
        fun prizeTestCases(): List<Arguments> = listOf(
            Arguments.of(6, false, Prize.FIRST),
            Arguments.of(5, true, Prize.SECOND),
            Arguments.of(5, false, Prize.THIRD),
            Arguments.of(4, false, Prize.FOURTH),
            Arguments.of(3, false, Prize.FIFTH)
        )
    }
}
