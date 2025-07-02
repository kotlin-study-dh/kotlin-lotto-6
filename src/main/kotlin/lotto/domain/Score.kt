package lotto.domain

enum class Score(private val matchRule: (Int, Boolean) -> Boolean, val prize: Int) {

    FIRST({ winningMatch, bonus -> winningMatch == 6 }, 2_000_000_000),
    SECOND({ winningMatch, bonus -> winningMatch == 5 && bonus }, 30_000_000),
    THIRD({ winningMatch, bonus -> winningMatch == 5 && !bonus }, 1_500_000),
    FOURTH({ winningMatch, bonus -> winningMatch == 4 }, 50_000),
    FIFTH({ winningMatch, bonus -> winningMatch == 3 }, 5_000),
    NO_WAY({ winningMatch, bonus -> winningMatch < 3 }, 0);

    companion object {
        fun from(winningMatches: Int, bonusMatch: Boolean): Score {
            return entries.find {
                it.matchRule(winningMatches, bonusMatch)
            } ?: throw IllegalArgumentException("Winning $winningMatches and Bonus: $bonusMatch not found")
        }
    }
}