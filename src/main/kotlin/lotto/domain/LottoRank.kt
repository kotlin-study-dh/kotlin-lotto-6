package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val isBonusRequired: Boolean,
    val prizeMoney: Long
) {

    NO_PRIZE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    companion object {
        fun of(matchCount: Int, matchesBonus: Boolean) =
            LottoRank.entries.find {
                (it.matchCount == matchCount) && (!it.isBonusRequired || matchesBonus)
            } ?: NO_PRIZE
    }
}
