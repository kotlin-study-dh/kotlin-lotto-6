package lotto.domain

enum class LottoRank(
    val matchCounts: Int,
    val prizeAmount: Int
) {
    SIX_MATCH(6, 2_000_000_000),
    FIVE_BONUS_MATCH(5, 30_000_000),
    FIVE_MATCH(5, 1_500_000),
    FOUR_MATCH(4, 50_000),
    THREE_MATCH(3, 5_000),
    NONE_MATCH(0, 0);

    companion object {
        fun getRank(matchCounts: Int, hasBonus: Boolean): LottoRank {
            return when (matchCounts) {
                SIX_MATCH.matchCounts -> SIX_MATCH
                FIVE_MATCH.matchCounts -> if (hasBonus) FIVE_BONUS_MATCH else FIVE_MATCH
                FOUR_MATCH.matchCounts -> FOUR_MATCH
                THREE_MATCH.matchCounts -> THREE_MATCH
                else -> NONE_MATCH
            }
        }
    }
}
