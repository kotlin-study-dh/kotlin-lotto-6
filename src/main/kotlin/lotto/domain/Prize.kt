package lotto.domain

enum class Prize(
    val winningAmount: Int,
    val matchCount: Int,
) {
    NONE(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    companion object {
        private const val MIN_MATCH_COUNT = 0
        private const val MAX_MATCH_COUNT = 6

        fun of(matchCount: Int, hasBonusNumber: Boolean): Prize {
            require(matchCount in MIN_MATCH_COUNT..MAX_MATCH_COUNT) {
                "Match count must be between 0 and 6."
            }
            return when (matchCount) {
                FIRST.matchCount -> FIRST
                SECOND.matchCount -> if (hasBonusNumber) SECOND else THIRD
                FOURTH.matchCount -> FOURTH
                FIFTH.matchCount -> FIFTH
                else -> NONE
            }
        }
    }
}
