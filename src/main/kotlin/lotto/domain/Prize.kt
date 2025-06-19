package lotto.domain

enum class Prize(val matchedCount: Int, val shouldBonusMatch: Boolean, val reward: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

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