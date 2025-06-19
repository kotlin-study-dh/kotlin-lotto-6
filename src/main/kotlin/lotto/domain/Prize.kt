package lotto.domain

enum class Prize(val matchedCount: Int, val shouldBonusMatch: Boolean, val reward: Long) {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L);

    // todo: improve
    companion object {
        fun of(matchedCount: Int, bonusMatched: Boolean): Prize? = when (matchedCount) {
            6 -> FIRST
            5 -> if (bonusMatched) SECOND else THIRD
            4 -> FOURTH
            3 -> FIFTH
            else -> null
        }
    }

}